package api_builder.app.conf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

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

	@GetMapping("/admin")
	public String displayAdminHome() {
		return "admin/admin";
	}
}
