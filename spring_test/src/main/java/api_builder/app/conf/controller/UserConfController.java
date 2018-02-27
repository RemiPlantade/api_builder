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
			if(!userService.save(user)) {
				model.addAttribute("error_title","User connot be added");
				model.addAttribute("error_message","User with this mail OR username already exists.");
				model.addAttribute("redirect_url","/admin/users");
				return "error";
			}
			return "redirect:/admin/users";
		}	
	}

	//	@GetMapping("/admin/user/edit")
	//	public String displayUserConfEdit(@RequestParam Integer id,Model model) {
	//		ApiUser user = userService.findById(id);
	//		model.addAttribute("user",user);
	//		model.addAttribute("groups",groupService.findAll());
	//		ApiUserPermWrapper userPerWrapper = new ApiUserPermWrapper();
	//		userPerWrapper.setUserPermList(userPermService.findByUser(user));
	//		model.addAttribute("userpermwrapper",userPerWrapper);
	//		return "admin/user/edit";
	//	}
	//
	//	@PostMapping(value = "/admin/user/edit")
	//	public String editUser(@Valid @ModelAttribute("user") ApiUser user,BindingResult errors, @RequestParam Integer id, Model model) {
	//		if (errors.hasErrors()) {
	//			return "admin/user/edit";
	//		}else {		
	//			try {
	//				userService.update(user);
	//			}catch(Exception e) {
	//				model.addAttribute("error_title","Error on save");
	//				model.addAttribute("error_message","Error occurs on saving user : <p>"+ e.getMessage() +"<\\p>");
	//				model.addAttribute("redirect_url","/admin/users");
	//				return "error";
	//			}
	//			return "redirect:/admin/users";
	//		}	
	//	}
	//
	//	@PostMapping(value = "/admin/user/edit/perm")
	//	public String editUserPerm(@ModelAttribute("userpermwrapper") ApiUserPermWrapper userPermWrapper, @RequestParam Integer id, Model model) {
	//		userPermService.updatePermFromWrapper(userPermWrapper);
	//		return "redirect:/admin/users";
	//	}

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
			//			try {
			userForm.getApiUser().setId(id);
			userService.update(userForm.getApiUser());
			userPermService.updatePermFromWrapper(userForm.getApiUserPermWrapper());
			//			}catch(Exception e) {
			//				model.addAttribute("error_title","Error on save");
			//				model.addAttribute("error_message","Error occurs on saving user : <p>"+ e.getMessage() +"<\\p>");
			//				model.addAttribute("redirect_url","/admin/users");
			//				return "error";
			//			}
			return "redirect:/admin/users";
		}	
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
