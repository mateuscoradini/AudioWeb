package com.privates.audio.web.entity;

import java.io.Serializable;



public class ProjectAudio implements Serializable {
	
	
	private Long id;
	

	private Audio Audio;

	private Project project;


	public Long getId() {
		return id;
	}


	public Audio getAudio() {
		return Audio;
	}


	public Project getProject() {
		return project;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setAudio(Audio audio) {
		Audio = audio;
	}


	public void setProject(Project project) {
		this.project = project;
	}

}
