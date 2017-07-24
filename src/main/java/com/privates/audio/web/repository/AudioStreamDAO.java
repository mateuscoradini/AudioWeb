package com.privates.audio.web.repository;

import com.privates.audio.web.entity.AudioStream;

public interface AudioStreamDAO {

	int save(AudioStream audioStream);

	AudioStream findByAudioId(Long id);

	int removeByAudioId(Long id);

}
