package com.privates.audio.web.repository;

import java.util.List;

import com.privates.audio.web.entity.Audio;

public interface AudioDAO {

	int save(Audio audio);

	Audio findById(Long id);

	List<Audio> findByProject(Long id);

	Integer findPermissionByUserId(Long userId, Long audioId);

	int removeAllAudioUser(Long id);

	int removeAllAudioRequests(Long id);

	int removeAudioProject(Long id);

	int removeById(Long id);

}
