package api_builder.app.conf.controller;

import java.security.SecureRandom;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import api_builder.app.conf.model.ApiUser;
import api_builder.app.conf.model.form.ApiUserPermWrapper;
import api_builder.app.conf.model.form.UserForm;
import api_builder.app.conf.service.ApiGroupService;
import api_builder.app.conf.service.ApiUserService;
import api_builder.app.conf.service.ApiUserPermService;
@SessionAttributes({"userForm","groups","user","users"})
@Controller
public class ApiUserController {

	@Autowired
	private ApiUserService userService;
	@Autowired
	private ApiGroupService groupService;
	@Autowired
	private ApiUserPermService userPermService;

	private SecureRandom random = new SecureRandom();

	@ModelAttribute("user")
	public ApiUser addNewUser() {
		return new ApiUser();
	}
	
	@ModelAttribute("users")
	public List<ApiUser> addAllUsers() {
		return userService.findAll();
	}
	
	

	@GetMapping("/admin/users")
	public String displayUserConf(Model model) {
		model.addAttribute("user", new ApiUser());
		model.addAttribute("users",userService.findAll());
		model.addAttribute("groups",groupService.findAll());
		return "admin/users";
	}


	@PostMapping(value = "/admin/users")
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
	
	@GetMapping("/admin/user/edit")
	public String displayUserForm(@RequestParam Integer id,Model model) {
		model.addAttribute("groups",groupService.findAll());
		model.addAttribute("userForm",createUserFormFromId(id));
		return "admin/user/edit";
	}


	@PostMapping(value = "/admin/user/edit")
	public String editUser(HttpServletRequest request,@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult errors, @RequestParam Integer id, Model model,SessionStatus session) {
		if (errors.hasErrors()) {
			request.getSession().setAttribute("groups",groupService.findAll());
			request.getSession().setAttribute( "userForm", userForm);
			return "admin/user/edit";
		}else {		
			try {
				userService.update(userForm.getApiUser());
				userPermService.updatePermFromWrapper(userForm.getApiUserPermWrapper());
				request.getSession().removeAttribute("userForm");
				request.getSession().removeAttribute("groups");
			}catch(Exception e) {
				model.addAttribute("error_title","Error on edit");
				model.addAttribute("error_message","Error occurs during user edition : <p>"+ e.getMessage() +"<\\p>");
				model.addAttribute("redirect_url","/admin/user/edit.id="+id);
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
	
	@GetMapping("/admin/user/quota")
	public String resetQuota(@RequestParam Integer id,Model model) {
		System.out.println(model.toString());
		ApiUser user = userService.findById(id);
		user.setActualquota(0L);
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
	
	private UserForm createUserFormFromId(Integer id) {
		ApiUser user = userService.findById(id);
		ApiUserPermWrapper userPerWrapper = new ApiUserPermWrapper();
		userPerWrapper.setUserPermList(userPermService.findByUser(user));
		UserForm userForm = new UserForm();
		userForm.setApiUser(user);
		userForm.setApiUserPermWrapper(userPerWrapper);
		return userForm;
	}
}
