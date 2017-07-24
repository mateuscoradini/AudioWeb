package com.privates.audio.web.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.repository.mapper.AudioRowMapper;

@Component
public class AudioDAOImpl extends JDBCBaseDAO implements AudioDAO {

	public static final String INSERT_QUERY = "INSERT INTO tb_audio (filename, enabled , insert_date) VALUES (:FILENAME, :ENABLED, :INSERT_DATE)";

	public static final String FIND_AUDIO_BY_PROJECT_AUDIO_BY_PROJECT_ID = "SELECT audio.*, t.project_id FROM tb_audio audio, tb_project_audio t where t.project_id = :PROJECT_ID AND audio.id = t.audio_id ORDER BY t.project_id";

	public static final String FIND_AUDIO_BY_USER_ID = "SELECT count(*) FROM tb_user_audio ua WHERE ua.user_id = :USER_ID and ua.audio_id = :AUDIO_ID;";

	public static final String FIND_BY_AUDIO_BY_ID = "SELECT a.*, t.project_id FROM tb_audio a, tb_project_audio t where a.id = :ID AND a.id = t.audio_id";
	
	public static final String DELETE_AUDIO_BY_ID_QUERY = "DELETE from tb_audio WHERE id = :ID ";

	public static final String DELETE_ALL_AUDIO_USER_BY_AUDIO_ID_QUERY = "DELETE from tb_user_audio WHERE audio_id = :AUDIO_ID ";
	
	public static final String DELETE_ALL_AUDIO_REQUESTS_BY_AUDIO_ID_QUERY = "DELETE from tb_audio_role WHERE audio_id = :AUDIO_ID ";
	
	public static final String DELETE_AUDIO_PROJECT_BY_AUDIO_ID_QUERY = "DELETE from tb_project_audio WHERE audio_id = :AUDIO_ID ";

	@Override
	public int save(Audio audio) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("FILENAME", audio.getFileName());
		mapSql.addValue("ENABLED", true);
		mapSql.addValue("INSERT_DATE", new Date());

		try {
			this.getNamedParameterJdbcTemplate().update(INSERT_QUERY, mapSql, keyHolder, new String[] { "ID" });
		} catch (Exception e) {
			return 0;
		}

		audio.setId(keyHolder.getKey().longValue());
		return 1;

	}

	@Override
	public Audio findById(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID", id);
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_BY_AUDIO_BY_ID, map, new AudioRowMapper());
	}

	@Override
	public List<Audio> findByProject(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PROJECT_ID", id);
		return this.getNamedParameterJdbcTemplate().query(FIND_AUDIO_BY_PROJECT_AUDIO_BY_PROJECT_ID, map,
				new AudioRowMapper());
	}

	@Override
	public Integer findPermissionByUserId(Long userId, Long audioId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("USER_ID", userId);
		map.put("AUDIO_ID", audioId);
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_AUDIO_BY_USER_ID, map, Integer.class);

	}

	@Override
	public int removeAllAudioUser(Long id) {
		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("AUDIO_ID", id);

		try {
			this.getNamedParameterJdbcTemplate().update(DELETE_ALL_AUDIO_USER_BY_AUDIO_ID_QUERY, mapSql);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@Override
	public int removeAllAudioRequests(Long id) {
		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("AUDIO_ID", id);

		try {
			this.getNamedParameterJdbcTemplate().update(DELETE_ALL_AUDIO_REQUESTS_BY_AUDIO_ID_QUERY, mapSql);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@Override
	public int removeAudioProject(Long id) {
		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("AUDIO_ID", id);

		try {
			this.getNamedParameterJdbcTemplate().update(DELETE_AUDIO_PROJECT_BY_AUDIO_ID_QUERY, mapSql);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@Override
	public int removeById(Long id) {
		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("ID", id);

		try {
			this.getNamedParameterJdbcTemplate().update(DELETE_AUDIO_BY_ID_QUERY, mapSql);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

}
