package com.privates.audio.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.privates.audio.web.entity.User;
import com.privates.audio.web.service.UserService;

@Controller
public class UserController {

	public static final String REDIRECT_URL = "redirect:/";

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User construct() {
		return new User();
	}

	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";

	}

	@RequestMapping("/users/{id}")
	public String getUserDetail(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.findById(id));
		return "user-detail";
	}

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("user", userService.findByName(username));
		return "user-detail";
	}
	

	@RequestMapping("/users/usersDetails")
	public String registerUsers(Model model) {
		return "user-details-form";
	}
	
	@RequestMapping("/users/userRequests")
	public String usersRequest(Model model) {
		return "user-requests-form";
	}
	
	@ResponseBody
	@RequestMapping(value = "/users/usersAudioRequest", method = RequestMethod.POST)
	public List<User> getUsersAudioRequest(@RequestBody String search) {
		return userService.findAllAudioRequests();

	}



}
