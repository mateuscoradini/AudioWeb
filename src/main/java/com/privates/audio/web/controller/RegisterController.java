package com.privates.audio.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.privates.audio.web.entity.User;
import com.privates.audio.web.service.UserService;

@Controller
public class RegisterController {

	public static final String REDIRECT_URL = "redirect:/";

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User construct() {
		return new User();
	}

	@RequestMapping("/register")
	public String registerUser(Model model) {
		return "register-form";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUserWithDefaultUserRole(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "register-form";
		}
		userService.save(user);

		return REDIRECT_URL + "register.html?success=true";

	}
	
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username) {
		Boolean available = userService.findByUsername(username) == null;
		return available.toString();
	}


}
