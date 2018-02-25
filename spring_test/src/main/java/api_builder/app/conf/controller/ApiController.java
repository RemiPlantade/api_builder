package api_builder.app.conf.controller;

import java.security.SecureRandom;

import javax.validation.Valid;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import api_builder.app.conf.dao.UserConfDao;
import api_builder.app.conf.model.UserConf;
import api_builder.app.conf.service.ApiConfService;
import api_builder.app.conf.service.UserConfService;

@Controller
public class ApiController {
	SecureRandom random = new SecureRandom();
	
	@Autowired
	private UserConfService userService;

	@Autowired
	private ApiConfService apiConfService;

	@GetMapping("/")
	public String displayIndex() {
		return "index";
	}

	@GetMapping("/login")
	public String displayLogin() {
		return "login";
	}
	// Login form with error
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

	//	  @RequestMapping("/error")
	//	  public String error() {
	//	    return "error";
	//	  }

	@GetMapping("/admin")
	public String displayAdminHome() {
		return "admin/admin";
	}

	@GetMapping("/admin/users")
	public String displayUserConf(Model model) {
		model.addAttribute("user", new UserConf());
		model.addAttribute("users",userService.getAll());
		return "admin/users";
	}
	
	@GetMapping("/admin/adduser")
	public ModelAndView fowardUseradd(Model model) {
		model.addAttribute("user", new UserConf());
		return new ModelAndView("admin/users",model.asMap());
	}
	

	@PostMapping(value = "/admin/adduser")
	public String addUser(@Valid @ModelAttribute("user") UserConf user, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "admin/users";
		}else {
			System.out.println("Inserting user");
			user.setToken(createToken());
			if(!userService.addUserConf(user)) {
				model.addAttribute("error_title","User connot be added");
				model.addAttribute("error_message","User with this mail OR username already exists.");
				model.addAttribute("redirect_url","/admin/users");
				return "error";
			}
			model.addAttribute("user",user);
			return "admin/users";
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
