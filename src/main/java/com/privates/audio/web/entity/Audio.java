package com.privates.audio.web.entity;

import java.io.Serializable;


public class Audio  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 214554032483773941L;

	private Long id;
	
	private String fileName;	
	
	private boolean enabled;
	
	private AudioStream audioStream;	
	
    private Project project;
    
    private boolean userHasPermission;
	

	public Long getId() {
		return id;
	}

	public String getFileName() {
		return fileName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public AudioStream getAudioStream() {
		return audioStream;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAudioStream(AudioStream audioStream) {
		this.audioStream = audioStream;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public boolean isUserHasPermission() {
		return userHasPermission;
	}

	public void setUserHasPermission(boolean userHasPermission) {
		this.userHasPermission = userHasPermission;
	}
	
	
	
	
	

}
