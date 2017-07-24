package com.privates.audio.web.entity;

import java.io.Serializable;

public class AudioStream implements Serializable {

	private Long id;


	private Audio audio;
	
	private byte[] audio_stream;

	public Long getId() {
		return id;
	}

	public Audio getAudio() {
		return audio;
	}

	public byte[] getAudio_stream() {
		return audio_stream;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public void setAudio_stream(byte[] audio_stream) {
		this.audio_stream = audio_stream;
	}



}
