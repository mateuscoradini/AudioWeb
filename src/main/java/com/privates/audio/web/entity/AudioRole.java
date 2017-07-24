package com.privates.audio.web.entity;

public class AudioRole {

	private Long id;
	private User user;
	private Audio audio;
	private String audioKey;

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Audio getAudio() {
		return audio;
	}

	public String getAudioKey() {
		return audioKey;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public void setAudioKey(String audioKey) {
		this.audioKey = audioKey;
	}

}
