package com.privates.audio.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.User;
import com.privates.audio.web.entity.UserAudio;
import com.privates.audio.web.repository.mapper.RoleRowMapper;
import com.privates.audio.web.repository.mapper.UserAudioRowMapper;

@Component
public class UserAudioDAOImpl extends JDBCBaseDAO implements UserAudioDAO {

	public static final String INSERT_USER_AUDIO = "INSERT INTO tb_user_audio ( user_id, audio_id) VALUES ( :USER_ID , :AUDIO_ID )";
	
	public static final String FIND_BY_USER_ID = "SELECT * FROM tb_user_audio t where t.user_id = :USER_ID";


	@Override
	public int save(Audio audio, User user) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("USER_ID", user.getId());
		mapSql.addValue("AUDIO_ID", audio.getId());

		try {
			this.getNamedParameterJdbcTemplate().update(INSERT_USER_AUDIO, mapSql, keyHolder, new String[] { "ID" });
		} catch (Exception e) {
			return 0;
		}

		// userRole.setId(keyHolder.getKey().longValue());
		return 1;
	}


	@Override
	public List<UserAudio> findByUserId(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("USER_ID", id);
		return this.getNamedParameterJdbcTemplate().query(FIND_BY_USER_ID, map, new UserAudioRowMapper());
	}

}
