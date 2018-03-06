package api_builder.app.conf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import api_builder.app.conf.model.ApiConf;
import api_builder.app.conf.model.form.ApiConfWrapper;
import api_builder.app.conf.service.ApiConfService;

@Controller
@SessionAttributes("apiConfWrapper")
@RefreshScope
public class ApiConfController {

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
		updateServerPort(apiConfWrapper);
		saveActualPorts(apiConfWrapper);
		apiConfService.updateConfFromWrapper(apiConfWrapper);
		session.removeAttribute("apiConfWrapper");
		sa.setComplete();
		return "admin/general";
	}

	private void updateServerPort(ApiConfWrapper apiConfWrapper) {
		ApiConf httpsEnable = null;
		ApiConf newHttpPort = null;
		ApiConf newHttpsPort = null;
		ApiConf serverPort = apiConfService.findByKey("server.port");

		for (ApiConf apiConf : apiConfWrapper.getApiConfList()) {
			httpsEnable = apiConf.getParamKey().equals("security.require-ssl") ? apiConf : httpsEnable;
			newHttpPort = apiConf.getParamKey().equals("api.port.http") ? apiConf : newHttpPort;
			newHttpsPort = apiConf.getParamKey().equals("api.port.https") ? apiConf : newHttpsPort;
		}
		if(httpsEnable.getParamValue().equals("true")) {
			serverPort.setParamValue(newHttpsPort.getParamValue());
		}else if(httpsEnable.getParamValue().equals("false")) {
			serverPort.setParamValue(newHttpPort.getParamValue());
		}
		apiConfWrapper.getApiConfList().add(serverPort);
		
	}

	private void saveActualPorts(ApiConfWrapper apiConfWrapper) {
		// Get actual port values
		String actualServerPort = apiConfService.findByParamKey("server.port").getParamValue();
		// Get new port values
		ApiConf newServerPort = null;
		for (ApiConf apiConf : apiConfWrapper.getApiConfList()) {
			newServerPort = apiConf.getParamKey().equals("server.port") ? apiConf : newServerPort;
		}
		// If they are changed on form update old port value with actual
		if(!newServerPort.equals(actualServerPort)) {
			ApiConf prevServerPort = apiConfService.findByKey("previous.api.port");
			prevServerPort.setParamValue(actualServerPort);
			apiConfWrapper.getApiConfList().add(prevServerPort);
		}

	}

	public ApiConfWrapper getApiConfWrapper() {
		ApiConfWrapper apiconfWrapper = new ApiConfWrapper();
		apiconfWrapper.setApiConfList(apiConfService.findAllModifiable());
		return apiconfWrapper;
	}
}
