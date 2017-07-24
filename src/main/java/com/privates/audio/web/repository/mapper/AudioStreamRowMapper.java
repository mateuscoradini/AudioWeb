package com.privates.audio.web.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.privates.audio.web.entity.AudioStream;

public class AudioStreamRowMapper implements RowMapper<AudioStream> {

	@Override
	public AudioStream mapRow(ResultSet rs, int rowNum) throws SQLException {

		AudioStream audioStream = new AudioStream();
		audioStream.setId(rs.getLong("ID"));
		audioStream.setAudio_stream(rs.getBytes("AUDIO_STREAM"));
		
		
		return audioStream;
	}

}
