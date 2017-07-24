package com.privates.audio.web.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.privates.audio.web.entity.AudioStream;
import com.privates.audio.web.repository.mapper.AudioRoleRowMapper;
import com.privates.audio.web.repository.mapper.AudioStreamRowMapper;

@Component
public class AudioStreamDAOImpl extends JDBCBaseDAO implements AudioStreamDAO {

	private static final String INSERT_QUERY = "INSERT INTO tb_audio_stream (`audio_id`,`audio_stream`)VALUES( :AUDIO_ID, :AUDIO_STREAM)";
	
	public static final String FIND_BY_AUDIO_ID_QUERY = "SELECT * FROM tb_audio_stream WHERE audio_id = :AUDIO_ID ";
	
	public static final String DELETE_AUDIO_STREAM_BY_AUDIO_ID_QUERY = "DELETE from tb_audio_stream WHERE audio_id = :AUDIO_ID ";

	@Override
	public int save(AudioStream audioStream) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("AUDIO_ID", audioStream.getAudio().getId());
		mapSql.addValue("AUDIO_STREAM", audioStream.getAudio_stream());

		try {
			this.getNamedParameterJdbcTemplate().update(INSERT_QUERY, mapSql, keyHolder, new String[] { "ID" });
		} catch (Exception e) {
			return 0;
		}

		audioStream.setId(keyHolder.getKey().longValue());
		return 1;

	}

	@Override
	public AudioStream findByAudioId(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AUDIO_ID", id);
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_BY_AUDIO_ID_QUERY, map, new AudioStreamRowMapper());
	}

	@Override
	public int removeByAudioId(Long id) {
		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("AUDIO_ID", id);

		try {
			this.getNamedParameterJdbcTemplate().update(DELETE_AUDIO_STREAM_BY_AUDIO_ID_QUERY, mapSql);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

}
