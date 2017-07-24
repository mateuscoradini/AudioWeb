package com.privates.audio.web.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.Project;
import com.privates.audio.web.entity.ProjectAudio;

public class ProjectAudioRowMapper implements RowMapper<ProjectAudio> {

	
	@Override
	public ProjectAudio mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProjectAudio projectAudio = new ProjectAudio();
		projectAudio.setId(rs.getLong("ID"));
		
		//Set Audio
		Audio audio = new Audio();
		audio.setId(rs.getLong("AUDIO_ID"));
		projectAudio.setAudio(audio);
		
		//Set Project
		Project project = new Project();
		project.setId(rs.getLong("PROJECT_ID"));
		projectAudio.setProject(project);
		
		return projectAudio;
	}

}
