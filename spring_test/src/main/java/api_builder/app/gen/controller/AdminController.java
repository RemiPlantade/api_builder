package api_builder.app.gen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/test/admin")
	public String displayLoginform(){
		return "";
	}
}
