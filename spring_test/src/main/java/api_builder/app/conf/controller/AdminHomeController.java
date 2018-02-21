package api_builder.app.conf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import api_builder.app.conf.service.ApiConfService;

@Controller
@RequestMapping("/test")
public class AdminHomeController {

	@Autowired
	private ApiConfService apiConfService;

	@GetMapping("/admin")
	public String displayHome() {
		return "adminlogin";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(defaultValue="") String mail, @RequestParam(defaultValue="") String password,ModelMap modelMap) {
		if(mail.equals("") || mail.equals("")) {
			modelMap.put("message_erreur", "Bad credentials");
			System.out.println(mail + "" + password);
			return "adminlogin";
		}else {
			return "adminhome";
		}
		
	}
}
