package com.privates.audio.web.repository;

import java.util.List;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.User;
import com.privates.audio.web.entity.UserAudio;

public interface UserAudioDAO {

	int save(Audio audio, User user);

	List<UserAudio> findByUserId(Long id);

}
