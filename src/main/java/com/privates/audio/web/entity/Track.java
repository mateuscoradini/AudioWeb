package com.privates.audio.web.entity;

import java.io.Serializable;

public class Track implements Serializable {
	
	private Long audioId;
	private int track;
	private String name;
	private double length;
	private String projectName;
	private byte[] file;
	
	public int getTrack() {
		return track;
	}
	public String getName() {
		return name;
	}
	public double getLength() {
		return length;
	}
	public byte[] getFile() {
		return file;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public Long getAudioId() {
		return audioId;
	}
	public void setAudioId(Long audioId) {
		this.audioId = audioId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	

}
