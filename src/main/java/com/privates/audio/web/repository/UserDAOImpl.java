package com.privates.audio.web.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.privates.audio.web.entity.User;
import com.privates.audio.web.repository.mapper.UserRowMapper;

@Component
public class UserDAOImpl extends JDBCBaseDAO implements UserDAO {

	public static final String FIND_ALL_QUERY = "SELECT u.* from tb_user u "
			+ " join tb_user_role on u.id = tb_user_role.user_id " + " WHERE tb_user_role.role_id != 1 ";

	public static final String INSERT_USER_QUERY = "INSERT INTO tb_user(username, name, email, password, insert_date, enabled) VALUES (:USERNAME, :NAME, :EMAIL, :PASSWORD, :INSERT_DATE, :ENABLED)";

	public static final String FIND_USER_BY_USERNAME_QUERY = "SELECT u.* from tb_user u WHERE u.username = :USERNAME ";

	public static final String FIND_USER_BY_ID_QUERY = "SELECT u.* from tb_user u WHERE u.id = :ID ";
	
	public static final String DELETE_USER_BY_ID_QUERY = "DELETE from tb_user u WHERE u.id = :ID ";

	@Override
	public User findById(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID", id);
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_USER_BY_ID_QUERY, map, new UserRowMapper());
	}

	@Override
	public int save(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("USERNAME", user.getUsername());
		mapSql.addValue("NAME", user.getName());
		mapSql.addValue("EMAIL", user.getEmail());
		mapSql.addValue("PASSWORD", user.getPassword());
		mapSql.addValue("ENABLED", 1);
		mapSql.addValue("INSERT_DATE", new Date());

		try {
			this.getNamedParameterJdbcTemplate().update(INSERT_USER_QUERY, mapSql, keyHolder, new String[] { "ID" });
		} catch (Exception e) {
			return 0;
		}

		user.setId(keyHolder.getKey().longValue());
		return 1;

	}

	@Override
	public User findByUsername(String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("USERNAME", username);
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_USER_BY_USERNAME_QUERY, map,
				new UserRowMapper());
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		return this.getNamedParameterJdbcTemplate().query(FIND_ALL_QUERY, map, new UserRowMapper());
	}

}
