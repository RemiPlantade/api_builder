package api_builder.app.conf.controller;

import java.security.SecureRandom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import api_builder.app.conf.model.ApiUser;
import api_builder.app.conf.model.form.ApiUserPermWrapper;
import api_builder.app.conf.model.form.UserForm;
import api_builder.app.conf.service.ApiGroupService;
import api_builder.app.conf.service.ApiUserService;
import api_builder.app.conf.service.ApiUserPermService;

@Controller
public class UserConfController {

	@Autowired
	private ApiUserService userService;
	@Autowired
	private ApiGroupService groupService;
	@Autowired
	private ApiUserPermService userPermService;

	private SecureRandom random = new SecureRandom();


	@GetMapping("/admin/users")
	public String displayUserConf(Model model) {
		model.addAttribute("user", new ApiUser());
		model.addAttribute("users",userService.findAll());
		model.addAttribute("groups",groupService.findAll());
		return "admin/users";
	}


	@PostMapping(value = "/admin/adduser")
	public String addUser(@Valid @ModelAttribute("user") ApiUser user,BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "admin/users";
		}else {
			user.setToken(createToken());
			System.out.println("============== Group : " + user.getGroup().getName() + "id :" + user.getGroup().getId());
			user.setGroup(groupService.findById(user.getGroup().getId()));
			if(!userService.save(user)) {
				model.addAttribute("error_title","User connot be added");
				model.addAttribute("error_message","User with this mail OR username already exists.");
				model.addAttribute("redirect_url","/admin/users");
				return "error";
			}
			return "redirect:/admin/users";
		}	
	}

	@GetMapping("/admin/user/edit")
	public String displayUserForm(@RequestParam Integer id,Model model) {
		ApiUser user = userService.findById(id);
		ApiUserPermWrapper userPerWrapper = new ApiUserPermWrapper();
		userPerWrapper.setUserPermList(userPermService.findByUser(user));
		UserForm userForm = new UserForm();
		userForm.setApiUser(user);
		userForm.setApiUserPermWrapper(userPerWrapper);
		model.addAttribute("groups",groupService.findAll());
		model.addAttribute("userForm",userForm);
		return "admin/user/edit";
	}

	@PostMapping(value = "/admin/user/edit")
	public String editUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult errors, @RequestParam Integer id, Model model) {
		if (errors.hasErrors()) {
			return "admin/user/edit";
		}else {		
			try {
				userForm.getApiUser().setId(id);
				userService.update(userForm.getApiUser());
				userPermService.updatePermFromWrapper(userForm.getApiUserPermWrapper());
			}catch(Exception e) {
				model.addAttribute("error_title","Error on edit");
				model.addAttribute("error_message","Error occurs during user edition : <p>"+ e.getMessage() +"<\\p>");
				model.addAttribute("redirect_url","/admin/user/edit");
				return "error";
			}
			return "redirect:/admin/users";
		}	
	}
	
	@GetMapping("/admin/user/token")
	public String resetToken(@RequestParam Integer id,Model model) {
		ApiUser user = userService.findById(id);
		user.setToken(createToken());
		userService.update(user);
		return "redirect:edit?id="+id;
	}

	public String createToken() {
		boolean present = false;
		String token = null;
		do {
			token = generateToken();
			present = userService.tokenExists(token);
		}while(present);
		return token;
	}

	public String generateToken() {
		long longToken = Math.abs( random.nextLong() );
		String random = Long.toString( longToken, 16 );
		return random;
	}
}
