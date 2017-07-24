package com.privates.audio.web.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.privates.audio.web.entity.User;

public class UserRowMapper implements RowMapper<User> {

	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setEmail(rs.getString("EMAIL"));
		user.setEnabled(rs.getBoolean("ENABLED"));
		user.setName(rs.getString("NAME"));
		user.setUsername(rs.getString("USERNAME"));

		return user;
	}

}


