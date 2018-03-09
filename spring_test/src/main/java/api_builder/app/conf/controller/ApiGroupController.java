package api_builder.app.conf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import api_builder.app.conf.model.ApiGroup;
import api_builder.app.conf.model.ApiGroupPerm;
import api_builder.app.conf.model.form.ApiGroupPermWrapper;
import api_builder.app.conf.model.form.GroupForm;
import api_builder.app.conf.service.ApiGroupPermService;
import api_builder.app.conf.service.ApiGroupService;
import api_builder.app.conf.service.ApiUserService;

@Controller
@SessionAttributes({"groupForm","groups","group"})
public class ApiGroupController {

	@Autowired
	private ApiUserService userService;

	@Autowired
	private ApiGroupService groupService;

	@Autowired ApiGroupPermService groupPermService;

	@ModelAttribute("group")
	public ApiGroup addNewGroup() {
		return new ApiGroup();
	}

	@ModelAttribute("users")
	public List<ApiGroup> addAllGroups() {
		return groupService.findAll();
	}

	@GetMapping("/admin/groups")
	public String displayGroupConf(Model model) {
		model.addAttribute("group", new ApiGroup());
		model.addAttribute("groups",groupService.findAll());
		//		model.addAttribute("users",userService.findAllNotInGroup());
		return "admin/groups";
	}

	@PostMapping("/admin/groups")
	public String addGroupConf(@Valid @ModelAttribute("group") ApiGroup group,BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "admin/groups";
		}else {			
			try{
				groupService.save(group);
			}catch(Exception e){
				model.addAttribute("error_title","Group cannot be added");
				model.addAttribute("error_message","Group with this name already exists.");
				model.addAttribute("redirect_url","/admin/groups");
				return "error";
			}
			return "redirect:/admin/groups";
		}	
	}

	@GetMapping("/admin/group/edit")
	public String displayGroupForm(@RequestParam Integer id,Model model) {
		model.addAttribute("groupForm",createGroupFormFromId(id));
		return "admin/group/edit";
	}

	@PostMapping(value = "/admin/group/edit")
	public String editUser(HttpServletRequest request,@Valid @ModelAttribute("groupForm") GroupForm groupForm,BindingResult errors, @RequestParam Integer id, Model model) {
		if (errors.hasErrors()) {
			request.getSession().setAttribute( "groupForm", groupForm);
			return "admin/group/edit";
		}else {		
			try {
				groupForm.getApiGroup().setId(id);
				groupService.update(groupForm.getApiGroup());
				for (ApiGroupPerm groupPerm  : groupForm.getApiGroupPermWrapper().getGroupPermList()) {
					groupPerm.setApiGroup(groupForm.getApiGroup());
				}
				groupPermService.updatePermFromWrapper(groupForm.getApiGroupPermWrapper());
				request.getSession().removeAttribute("groupForm");
			}catch(Exception e) {
				model.addAttribute("error_title","Error on save");
				model.addAttribute("error_message","Error occurs on saving group : <p>"+ e.getMessage() +"<\\p>");
				model.addAttribute("redirect_url","/admin/groups");
				return "error";
			}
			return "redirect:/admin/groups";
		}	
	}

	private GroupForm createGroupFormFromId(Integer id) {
		ApiGroup group = groupService.findById(id);
		ApiGroupPermWrapper groupPerWrapper = new ApiGroupPermWrapper();
		groupPerWrapper.setGroupPermList(groupPermService.findByGroup(group));
		GroupForm userForm = new GroupForm();
		userForm.setApiGroup(group);
		userForm.setApiGroupPermWrapper(groupPerWrapper);
		return userForm;
	}

}
