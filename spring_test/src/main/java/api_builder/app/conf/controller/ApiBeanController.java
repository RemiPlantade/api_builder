package api_builder.app.conf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import api_builder.app.conf.model.ApiBean;
import api_builder.app.conf.model.form.ApiBeanWrapper;
import api_builder.app.conf.service.ApiBeanService;

@Controller
public class ApiBeanController {
	@Autowired
	private ApiBeanService beanService;
	
	@GetMapping("/admin/entities")
	public String displayEntities(Model model) {
		ApiBeanWrapper beanWrapper = new ApiBeanWrapper();
		beanWrapper.setBeanList(beanService.findAll());
		model.addAttribute("beanWrapper",beanWrapper);
		return "admin/entities";
	}
	
	@PostMapping("/admin/entities/edit")
	public String updateEntities(@ModelAttribute("beanWrapper") ApiBeanWrapper beanWrapper, Model model) {
		for (ApiBean bean : beanWrapper.getBeanList()) {
			System.out.println("Bean " + bean.getId() +" " + bean.getName()+ " " + bean.getManaged());
		}
		beanService.updateGroupFromWrapper(beanWrapper);
		return "redirect:/admin/entities";
	}
	
	
	
}
