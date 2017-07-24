package com.privates.audio.web.controller;

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
public class UserAjaxController {

	@Autowired
	private UserService userService;



	@ModelAttribute("user")
	public User construct() {
		return new User();
	}

	@ResponseBody
	@RequestMapping(value = "/users/removeUser/{id}", method = RequestMethod.GET)
	public String removeUser(Model model, @PathVariable long id) {
		userService.removeById(id);
		return "user-detail-form";
	}

	@ResponseBody
	@RequestMapping(value = "/users/removeUserAjax", method = RequestMethod.POST)
	public String removeUserAjax(@RequestBody final String userId) {
		String response = "true";

		userService.removeById(Long.parseLong(userId.replace("\"", "")));
		return response;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/users/userInformation", method = RequestMethod.POST)
	public List<User> informationUser(@RequestBody final String username) {
		return userService.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/users/addUser", method = RequestMethod.POST)
	public String addUser(@RequestBody final User user) {
		String response = "true";
		userService.save(user);
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/users/findAllUsers", method = RequestMethod.POST)
	public List<User> getSearchResultViaAjax(@RequestBody String search) {
		return userService.findAll();

	}



	

}
