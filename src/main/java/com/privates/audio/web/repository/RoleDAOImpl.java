package com.privates.audio.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.privates.audio.web.entity.Role;
import com.privates.audio.web.entity.User;
import com.privates.audio.web.repository.mapper.RoleRowMapper;

@Component
public class RoleDAOImpl extends JDBCBaseDAO implements RoleDAO {
	
	public static final String FIND_ALL = "SELECT * FROM tb_role t";
	
	public static final String FIND_BY_USER_ROLE = "SELECT * FROM tb_role t where t.name = :NAME";
	
	public static final String PARAM_USER_ROLE = "ROLE_USER";
	
	public static final String INSERT_USER_ROLE = "INSERT INTO tb_user_role (user_id, role_id) VALUES ( :USER_ID, :ROLE_ID )";

	@Override
	public List<Role> findAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		return this.getNamedParameterJdbcTemplate().query(FIND_ALL, map, new RoleRowMapper());
	}

	@Override
	public List<Role> findUserRole() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("NAME", PARAM_USER_ROLE);
		return this.getNamedParameterJdbcTemplate().query(FIND_BY_USER_ROLE, map, new RoleRowMapper());
	}

	@Override
	public int save(Role userRole, User user) {
				
		KeyHolder keyHolder = new GeneratedKeyHolder();

		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("USER_ID", user.getId());
		mapSql.addValue("ROLE_ID", userRole.getId());

		try {
			this.getNamedParameterJdbcTemplate().update(INSERT_USER_ROLE, mapSql, keyHolder, new String[] { "ID" });
		} catch (Exception e) {
			return 0;
		}

		//userRole.setId(keyHolder.getKey().longValue());
		return 1;
	}

}
