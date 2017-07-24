package com.privates.audio.web.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.privates.audio.web.entity.Project;

public class ProjectRowMapper implements RowMapper<Project> {

	
	@Override
	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

		Project project = new Project();
		project.setId(rs.getLong("ID"));
		project.setName(rs.getString("NAME"));
		//project.setKey(rs.getString("PROJECT_KEY"));
		project.setInsertDate(rs.getTimestamp("INSERT_DATE"));
		project.setScope(rs.getString("SCOPE"));
		project.setEnabled(rs.getBoolean("ENABLED"));

		return project;
	}

}
