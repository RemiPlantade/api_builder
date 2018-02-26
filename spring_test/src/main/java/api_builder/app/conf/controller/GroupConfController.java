package api_builder.app.conf.controller;

import java.util.ArrayList;

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
import api_builder.app.conf.service.GroupConfService;
import api_builder.app.conf.service.UserConfService;

@Controller
public class GroupConfController {
	
	@Autowired
	private UserConfService userService;
	
	@Autowired
	private GroupConfService groupService;
	
	@GetMapping("/admin/groups")
	public String displayGroupConf(Model model) {
		model.addAttribute("group", new GroupConf());
		model.addAttribute("groups",groupService.getAll());
		model.addAttribute("users",userService.getAllUsersNotINGroup());
		return "admin/groups";
	}
	
	@PostMapping("/admin/addgroup")
	public String addGroupConf(@Valid @ModelAttribute("group") GroupConf group,BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "admin/groups";
		}else {			
			if(!groupService.addGroupConf(group)) {
				model.addAttribute("error_title","Group cannot be added");
				model.addAttribute("error_message","Group with this name already exists.");
				model.addAttribute("redirect_url","/admin/groups");
				return "error";
			}
			return "redirect:/admin/groups";
		}	
	}
	
	@GetMapping("/admin/group/edit")
	public String displayGroupConfEdit(@RequestParam Integer id,Model model) {
		model.addAttribute("group",groupService.getGroupConfById(id));
		return "admin/group/edit";
	}
	
	@PostMapping(value = "/admin/group/edit")
	public String editUser(@Valid @ModelAttribute("group") GroupConf group,BindingResult errors, @RequestParam Integer id, Model model) {
		if (errors.hasErrors()) {
			return "admin/group/edit";
		}else {		
			try {
				groupService.updateGroupConf(group,id);
				}catch(Exception e) {
					model.addAttribute("error_title","Error on save");
					model.addAttribute("error_message","Error occurs on saving group : <p>"+ e.getMessage() +"<\\p>");
					model.addAttribute("redirect_url","/admin/groups");
					return "error";
				}
			return "redirect:/admin/groups";
		}	
	}
}
