package com.privates.audio.web.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.AudioRole;
import com.privates.audio.web.entity.User;

public class AudioRoleRowMapper implements RowMapper<AudioRole> {

	@Override
	public AudioRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		AudioRole audioRole = new AudioRole();
		Audio audio = new Audio();
		audio.setId(rs.getLong("AUDIO_ID"));

		// Set User
		User user = new User();
		user.setId(rs.getLong("USER_ID"));

		audioRole.setAudio(audio);
		audioRole.setUser(user);
		audioRole.setAudioKey(rs.getString("AUDIO_ROLE_KEY"));
		audioRole.setId(rs.getLong("ID"));

		return audioRole;
	}

}
