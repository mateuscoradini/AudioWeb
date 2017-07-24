package com.privates.audio.web.entity;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


public class User implements Serializable {

	private Long id;
	
	@Size(min = 5, max = 30, message = "Username must be at least 5 characters!")
	private String username;
	
	private String name;

	@Email
	private String email;

	@Size(min = 6,  message = "Password must be at least 6 characters!")
	private String password;

	private List<Role> listRoles;

	private boolean enabled;
	
	
	private Project project;
	private Audio audio;
	private AudioRole audioRole;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<Role> list) {
		this.listRoles = list;
	}

	public Project getProject() {
		return project;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public AudioRole getAudioRole() {
		return audioRole;
	}

	public void setAudioRole(AudioRole audioRole) {
		this.audioRole = audioRole;
	}

}
