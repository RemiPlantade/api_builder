package api_builder.app.conf.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import api_builder.app.conf.model.form.ApiConfWrapper;
import api_builder.app.conf.service.ApiConfService;

@Controller
@SessionAttributes("apiConfWrapper")
@RefreshScope
public class ApiConfController {
	
	//@Value("${server.port}")
	private String port;
	
	
	@Value("${security.require-ssl}")
	private String https;

	@Autowired
	private ApiConfService apiConfService;	
	
	@ModelAttribute("apiConfWrapper")
	public ApiConfWrapper addNewRapperConf() {
		return getApiConfWrapper();
	}

	@GetMapping("/admin/general")
	public String displayUserConf(Model model) {
		model.addAttribute("apiConfWrapper", getApiConfWrapper());
		return "admin/general";
	}
	

	@PostMapping(value = "/admin/general")
	public String addUser(HttpSession session, @ModelAttribute("apiConfWrapper") ApiConfWrapper apiConfWrapper, Model model, SessionStatus sa) {
		apiConfService.updateConfFromWrapper(apiConfWrapper);
		session.removeAttribute("apiConfWrapper");
		port = apiConfService.findByParamName("Port").getParamValue();
		https = apiConfService.findByParamName("Protocol HTTPS").getParamValue();
		sa.setComplete();
		return "admin/general";
	}
	
	public ApiConfWrapper getApiConfWrapper() {
		ApiConfWrapper apiconfWrapper = new ApiConfWrapper();
		apiconfWrapper.setApiConfList(apiConfService.findAll());
		return apiconfWrapper;
	}
}
