package com.privates.audio.web.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.User;
import com.privates.audio.web.entity.UserAudio;

public class UserAudioRowMapper implements RowMapper<UserAudio> {

	@Override
	public UserAudio mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserAudio userAudio = new UserAudio();
		Audio audio = new Audio();
		audio.setId(rs.getLong("AUDIO_ID"));

		userAudio.setAudio(audio);

		User user = new User();
		user.setId(rs.getLong("USER_ID"));

		userAudio.setUser(user);
		userAudio.setId(rs.getLong("ID"));

		return userAudio;
	}

}
