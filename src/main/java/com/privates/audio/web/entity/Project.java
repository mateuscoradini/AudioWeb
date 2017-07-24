package com.privates.audio.web.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class Project implements Serializable {
	

	private Long id;
	
	private String name;
	
	private String scope;	

	private String key;	

	private Date insertDate;		

	private boolean enabled;
	
	private List<Audio> listAudio;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Collection<Audio> getListAudio() {
		return listAudio;
	}

	public void setListAudio(List<Audio> listAudio) {
		this.listAudio = listAudio;
	}
//
//	public Collection<User> getListUsers() {
//		return listUsers;
//	}
//
//	public void setListUsers(Collection<User> listUsers) {
//		this.listUsers = listUsers;
//	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

}
