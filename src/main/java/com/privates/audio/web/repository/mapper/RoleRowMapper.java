package com.privates.audio.web.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.privates.audio.web.entity.Role;

public class RoleRowMapper implements RowMapper<Role> {

	
	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {

		Role role = new Role();
		role.setId(rs.getLong("ID"));
		role.setName(rs.getString("NAME"));

		return role;
	}

}
