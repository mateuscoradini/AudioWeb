package com.privates.audio.web.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.Project;

public class AudioRowMapper implements RowMapper<Audio> {

	@Override
	public Audio mapRow(ResultSet rs, int rowNum) throws SQLException {

		Audio audio = new Audio();
		audio.setId(rs.getLong("ID"));
		audio.setFileName(rs.getString("FILENAME"));
		audio.setEnabled(rs.getBoolean("ENABLED"));
		
		Project project = new Project();
		project.setId(rs.getLong("PROJECT_ID"));
		audio.setProject(project);
		
		return audio;
	}

}
