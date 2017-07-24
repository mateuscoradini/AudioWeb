package com.privates.audio.web.repository;

import java.util.List;

import com.privates.audio.web.entity.ProjectAudio;

public interface ProjectAudioDAO {
	
	int save(ProjectAudio projectAudio);

	List<ProjectAudio> findByProject(Long id);

	ProjectAudio findByAudio(Long id);

}
