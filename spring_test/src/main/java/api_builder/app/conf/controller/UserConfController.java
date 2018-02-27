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

import api_builder.app.conf.model.GroupConf;
import api_builder.app.conf.model.UserConf;
import api_builder.app.conf.model.UserPermissionConf;
import api_builder.app.conf.model.wrapper.UserPermissionWrapper;
import api_builder.app.conf.model.wrapper.UserPermissionsConfWrapper;
import api_builder.app.conf.service.GroupConfService;
import api_builder.app.conf.service.UserConfService;
import api_builder.app.conf.service.UserPermissionConfService;

@Controller
public class UserConfController {

	@Autowired
	private UserConfService userService;
	@Autowired
	private GroupConfService groupService;
	@Autowired
	private UserPermissionConfService userPermService;

	private SecureRandom random = new SecureRandom();


	@GetMapping("/admin/users")
	public String displayUserConf(Model model) {
		model.addAttribute("user", new UserConf());
		model.addAttribute("users",userService.getAll());
		model.addAttribute("groups",groupService.getAll());
		return "admin/users";
	}


	@PostMapping(value = "/admin/adduser")
	public String addUser(@Valid @ModelAttribute("user") UserConf user,BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "admin/users";
		}else {
			user.setToken(createToken());
			if(!userService.addUserConf(user)) {
				model.addAttribute("error_title","User connot be added");
				model.addAttribute("error_message","User with this mail OR username already exists.");
				model.addAttribute("redirect_url","/admin/users");
				return "error";
			}
			return "redirect:/admin/users";
		}	
	}

	@GetMapping("/admin/user/edit")
	public String displayUserConfEdit(@RequestParam Integer id,Model model) {
		UserConf user = userService.getUserConfById(id);
		model.addAttribute("user",user);
		model.addAttribute("groups",groupService.getAll());
		UserPermissionsConfWrapper userPerWrapper = new UserPermissionsConfWrapper();
		userPerWrapper.setUserPermList(userPermService.getAllUserPerm(user));
		model.addAttribute("userpermwrapper",userPerWrapper);
		return "admin/user/edit";
	}

	@PostMapping(value = "/admin/user/edit")
	public String editUser(@Valid @ModelAttribute("user") UserConf user,BindingResult errors, @RequestParam Integer id, Model model) {
		if (errors.hasErrors()) {
			return "admin/user/edit";
		}else {		
			try {
				userService.updateUserConf(user);
			}catch(Exception e) {
				model.addAttribute("error_title","Error on save");
				model.addAttribute("error_message","Error occurs on saving user : <p>"+ e.getMessage() +"<\\p>");
				model.addAttribute("redirect_url","/admin/users");
				return "error";
			}
			return "redirect:/admin/users";
		}	
	}

	@PostMapping(value = "/admin/user/edit/perm")
	public String editUserPerm(@ModelAttribute("userpermwrapper") UserPermissionsConfWrapper userPermWrapper, @RequestParam Integer id, Model model) {
		userPermService.updatePermFromWrapper(userPermWrapper);
		
//		try {
//			userPermService.updatePermFromWrapper(userPermWrapper);
//		}catch(Exception e) {
//			model.addAttribute("error_title","Error on save");
//			model.addAttribute("error_message","Error occurs on saving user : <p>"+ e.getMessage() +"<\\p>");
//			model.addAttribute("redirect_url","/admin/users");
//			return "error";
//		}
		return "redirect:/admin/users";
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
