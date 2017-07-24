package com.privates.audio.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.AudioRole;
import com.privates.audio.web.entity.User;
import com.privates.audio.web.repository.mapper.AudioRoleRowMapper;

@Component
public class AudioRoleDAOImpl extends JDBCBaseDAO implements AudioRoleDAO {

	public static final String INSERT_QUERY = "INSERT INTO mydb.tb_audio_role (audio_id, audio_role_key, user_id) VALUES ( :AUDIO_ID, :AUDIO_ROLE_KEY, :USER_ID)";

	public static final String FIND_ALL_QUERY = "SELECT * FROM tb_audio_role";
	
	public static final String FIND_BY_ID_QUERY = "SELECT * FROM tb_audio_role WHERE id = :ID ";
	
	public static final String DELETE_BY_ID_QUERY = "DELETE FROM tb_audio_role WHERE id = :ID ";
	
	@Override
	public int save(User user, Audio audio) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("AUDIO_ID", audio.getId());
		mapSql.addValue("USER_ID", user.getId());
		mapSql.addValue("AUDIO_ROLE_KEY", audio.getId());

		try {
			this.getNamedParameterJdbcTemplate().update(INSERT_QUERY, mapSql, keyHolder, new String[] { "ID" });
		} catch (Exception e) {
			return 0;
		}

		audio.setId(keyHolder.getKey().longValue());
		return 1;

	}
	
	@Override
	public AudioRole findById(Long audioRoleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID", audioRoleId);
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_BY_ID_QUERY , map,	new AudioRoleRowMapper());
	}

	@Override
	public List<AudioRole> findAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		return this.getNamedParameterJdbcTemplate().query(FIND_ALL_QUERY , map,	new AudioRoleRowMapper());
	}

	@Override
	public void deleteById(Long audioRoleId) {		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID", audioRoleId);
		this.getNamedParameterJdbcTemplate().update(DELETE_BY_ID_QUERY, map);		
		
	}

}
