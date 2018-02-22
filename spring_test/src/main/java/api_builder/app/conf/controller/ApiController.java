package api_builder.app.conf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import api_builder.app.conf.service.ApiConfService;

@Controller
@RequestMapping("/test")
public class ApiController {

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
	
	@GetMapping("/admin")
	public String displayAdminHome() {
		return "admin/admin";
	}
	
	@GetMapping("/unauth")
	public String displayUnauth() {
		return "unauthentified";
	}
	
//	@PostMapping("/login")
//	public ModelAndView login(@RequestParam(defaultValue="") String mail, @RequestParam(defaultValue="") String password,ModelMap modelMap,RedirectAttributes redir) {
//		if(mail.equals("") || mail.equals("")) {
//			redir.addFlashAttribute("message_erreur","Bad credentials");
//			return new ModelAndView("redirect:admin", modelMap);
//		}else {
//		   return new ModelAndView("redirect:admin/home", modelMap);
//		}
//	}
	
	
}
