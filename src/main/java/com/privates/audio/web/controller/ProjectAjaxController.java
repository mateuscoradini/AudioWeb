package com.privates.audio.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.Project;
import com.privates.audio.web.service.ProjectService;
import com.privates.audio.web.service.UserService;

@Controller
public class ProjectAjaxController {
	
	public static final String REDIRECT_URL = "redirect:/";


	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;

	@ModelAttribute("project")
	public Project construct() {
		return new Project();
	}	
	
	@RequestMapping("/projects/projectsDetails")
	public String users(Model model) {
		return "project-register-form";
	}
	
	@ResponseBody
	@RequestMapping(value = "/projects/projectsDetailsInformation", method = RequestMethod.GET)
	public List<Project> projects(Model model) {
		return projectService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/projects/projectAudios", method = RequestMethod.POST) // @RequestParam("projectName") String projectName
	public List<Audio> getAllProjectAudio(Model model, @RequestBody final String projectName) {
		return projectService.findAllAudiosByProject(projectName);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/projects/addProject", method = RequestMethod.POST)
	public String addUser(@RequestBody final Project project) {
		String response = "true";
		projectService.save(project);
		return response;
	}
	
	@RequestMapping(value = "/projects/projectsDetails", method = RequestMethod.POST)
	public String registerUserWithDefaultUserRole(@Valid @ModelAttribute("project") Project project, BindingResult result) {
		if (result.hasErrors()) {
			return "register-form";
		}
		projectService.save(project);

		return REDIRECT_URL + "projects/projectsDetails.html?success=true";

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/projects/removeProjectAjax", method = RequestMethod.POST)
	public String removeUserAjax(@RequestBody final String projectId) {
		String response = "true";
		
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		User user = userService.findByUsername(userDetails.getUsername());
		projectService.removeById(Long.parseLong(projectId.replace("\"", "")));
		return response;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/projects/changeAudioKeyByAjax", method = RequestMethod.POST)
	public String changeAudioKeyByAjax(@RequestBody final String audioId) {
		String response = "true";
		projectService.changeAudioKey(Long.parseLong(audioId.replace("\"", "")));
		return response;
	}


}
