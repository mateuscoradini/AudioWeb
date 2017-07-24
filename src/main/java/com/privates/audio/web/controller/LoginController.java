package com.privates.audio.web.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logged")
	public String logged(Model model) {

		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userDetails.getAuthorities();

			boolean hasRole = false;
			for (GrantedAuthority authority : authorities) {
				hasRole = authority.getAuthority().equals("ROLE_ADMIN");
				if (hasRole) {
					return "logged";
				}
			}

			return "user-audio";
		} catch (Exception e) {
			return "login";
		}

	}

}
