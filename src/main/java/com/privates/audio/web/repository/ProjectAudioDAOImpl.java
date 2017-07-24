package com.privates.audio.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.privates.audio.web.entity.ProjectAudio;
import com.privates.audio.web.repository.mapper.ProjectAudioRowMapper;

@Component
public class ProjectAudioDAOImpl extends JDBCBaseDAO implements ProjectAudioDAO {

	public static final String INSERT_QUERY = "INSERT INTO tb_project_audio (project_id, audio_id )VALUES (:PROJECT_ID ,:AUDIO_ID)";
	
	public static final String FIND_BY_PROJECT_AUDIO_BY_PROJECT_ID = "SELECT * FROM tb_project_audio t where t.project_id = :PROJECT_ID";
	
	public static final String FIND_BY_PROJECT_PROJECT_BY_AUDIO_ID = "SELECT * FROM tb_project_audio t where t.audio_id = :AUDIO_ID";
	
	
	
	public static final String FIND_BY_PROJECT_NAME_QUERY = "SELECT * FROM tb_project t where t.name = :PROJECT_NAME";
	
	
	@Override
	public int save(ProjectAudio projectAudio) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("AUDIO_ID", projectAudio.getAudio().getId());
		mapSql.addValue("PROJECT_ID", projectAudio.getProject().getId());
		
		try {
			this.getNamedParameterJdbcTemplate().update(INSERT_QUERY, mapSql, keyHolder, new String[] { "ID" });
		} catch (Exception e) {
			return 0;
		}

		projectAudio.setId(keyHolder.getKey().longValue());
		return 1;

	}
	
	
	@Override
	public List<ProjectAudio> findByProject(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PROJECT_ID", id);
		return this.getNamedParameterJdbcTemplate().query(FIND_BY_PROJECT_AUDIO_BY_PROJECT_ID, map, new ProjectAudioRowMapper());		
	}
	
	@Override
	public ProjectAudio findByAudio(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AUDIO_ID", id);
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_BY_PROJECT_PROJECT_BY_AUDIO_ID, map, new ProjectAudioRowMapper());		
	}

}
