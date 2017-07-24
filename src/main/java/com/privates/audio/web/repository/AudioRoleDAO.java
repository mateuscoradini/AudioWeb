package com.privates.audio.web.repository;

import java.util.List;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.AudioRole;
import com.privates.audio.web.entity.User;

public interface AudioRoleDAO {

	int save(User user, Audio audio);

	List<AudioRole> findAll();

	AudioRole findById(Long audioRoleId);

	void deleteById(Long audioRoleId);

}
