package com.privates.audio.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.AudioRole;
import com.privates.audio.web.entity.AudioStream;
import com.privates.audio.web.entity.Project;
import com.privates.audio.web.entity.ProjectAudio;
import com.privates.audio.web.entity.User;
import com.privates.audio.web.entity.UserAudio;
import com.privates.audio.web.repository.AudioDAO;
import com.privates.audio.web.repository.AudioRoleDAO;
import com.privates.audio.web.repository.AudioStreamDAO;
import com.privates.audio.web.repository.ProjectAudioDAO;
import com.privates.audio.web.repository.ProjectDAO;
import com.privates.audio.web.repository.UserAudioDAO;
import com.privates.audio.web.repository.UserDAO;

@Service
@Transactional
public class AudioService {

	@Autowired
	private AudioDAO audioDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private AudioStreamDAO audioStreamDAO;

	@Autowired
	private ProjectAudioDAO projectAudioDAO;
	
	@Autowired
	private AudioRoleDAO audioRoleDAO;

	@Autowired
	private ProjectDAO projectDAO;
	
	@Autowired
	private UserAudioDAO userAudioDAO;

	public Audio save(Audio audio) {
		audioDAO.save(audio);
		audio.getAudioStream().setAudio(audio);
		audioStreamDAO.save(audio.getAudioStream());
		return audio;

	}

	public ProjectAudio saveProjectAudio(ProjectAudio projectAudio) {
		projectAudioDAO.save(projectAudio);
		return projectAudio;
	}

	public Map<Project, List<Audio>> getAllProjectAudios(UserDetails userDetails) {
		
		User user =  userDAO.findByUsername(userDetails.getUsername());
		Map<Project, List<Audio>> mapProjectListAudio = new LinkedHashMap<Project, List<Audio>>();
		List<Project> listProjects = projectDAO.findAll();
		for (Project project : listProjects) {
			List<Audio> audioList = audioDAO.findByProject(project.getId());
			if (!audioList.isEmpty()) {
				
				for(Audio audio : audioList){
					if(audioDAO.findPermissionByUserId(user.getId(), audio.getId()) >=1){
						audio.setUserHasPermission(true);
					}
				}
				
				mapProjectListAudio.put(project, audioList);
			}
		}		
		return mapProjectListAudio;

	}

	public void addAudioPermissionRequest(UserDetails userDetails, long parseLong) {
		User user =  userDAO.findByUsername(userDetails.getUsername());
		Audio audio = audioDAO.findById(parseLong);
		audioRoleDAO.save(user, audio);
	}

	public void createUserAudio(Long audioRoleId) {
		AudioRole audioRole = audioRoleDAO.findById(audioRoleId);
		Audio audio = audioDAO.findById(audioRole.getAudio().getId());
		User user = userDAO.findById(audioRole.getUser().getId());
		userAudioDAO.save(audio, user);
		
		audioRoleDAO.deleteById(audioRoleId);
		
		
	}

	public List<Audio> findAudioAndStreamByUser(UserDetails userDetails) {
		User user =  userDAO.findByUsername(userDetails.getUsername());
		List<Audio> listAudios = new ArrayList<Audio>();
		List<UserAudio> listUserAudios = userAudioDAO.findByUserId(user.getId());
		for(UserAudio userAudio : listUserAudios){
			Audio audio = audioDAO.findById(userAudio.getAudio().getId());
			//TODO Colocar Descriptografia aqui por usuario e permissao
			AudioStream audioStream = audioStreamDAO.findByAudioId(userAudio.getAudio().getId());
			audio.setAudioStream(audioStream);
			ProjectAudio projectAudio = projectAudioDAO.findByAudio(audio.getId());
			Project project = projectDAO.findById(projectAudio.getProject().getId());
			audio.setProject(project);
			listAudios.add(audio);
			
		}
		
		return listAudios;
		
	}
	
	
	public Audio findById(Long audioId) {
		Audio audio = audioDAO.findById(audioId);
		audio.setAudioStream(audioStreamDAO.findByAudioId(audioId));
		return audio;

	}

}
