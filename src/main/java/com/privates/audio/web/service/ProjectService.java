package com.privates.audio.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.AudioStream;
import com.privates.audio.web.entity.Project;
import com.privates.audio.web.entity.ProjectAudio;
import com.privates.audio.web.entity.Role;
import com.privates.audio.web.entity.User;
import com.privates.audio.web.repository.AudioDAO;
import com.privates.audio.web.repository.AudioStreamDAO;
import com.privates.audio.web.repository.ProjectAudioDAO;
import com.privates.audio.web.repository.ProjectDAO;
import com.privates.audio.web.repository.UserDAO;

@Service
@Transactional
public class ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ProjectAudioDAO projectAudioDAO;

	@Autowired
	private AudioDAO audioDAO;
	
	@Autowired
	private AudioStreamDAO audioStreamDAO;

	public List<Project> findAll() {
		List<Project> listProjects = projectDAO.findAll();
		return listProjects;
	}

	public Project save(Project project) {
		project.setEnabled(true);
		project.setInsertDate(new Date());
		projectDAO.save(project);
		return project;

	}

	public Project findByName(String projectName) {
		return projectDAO.findByName(projectName);
	}

	public List<Audio> findAllAudiosByProject(String projectName) {
		projectName = projectName.replace("\"", "");
		Project project = projectDAO.findByName(projectName);
		List<ProjectAudio> projectAudios = projectAudioDAO.findByProject(project.getId());
		List<Audio> audiosByProject = new ArrayList<Audio>();
		for (ProjectAudio projectAudio : projectAudios) {
			Audio audio = audioDAO.findById(projectAudio.getAudio().getId());
			audiosByProject.add(audio);
		}

		return audiosByProject;
	}

	public void removeById(long projectID) {
		projectDAO.removeById(projectID);
	}

	public Project findById(Long id) {
		Project project = projectDAO.findById(id);
		return project;
	}

	public void changeAudioKey(long audioId) {
		
		Audio audio = audioDAO.findById(audioId);
		AudioStream audioStream = audioStreamDAO.findByAudioId(audioId);
		Project project = projectDAO.findById(audio.getProject().getId());
		
		removeAllAudioUsers(audio);
		removeAllAudioRequests(audio);
		removeAudioProject(audio);
		removeAudioStream(audio);
		removeAudio(audio);
		
		createNewAudio(audio, audioStream, project);
				
	}

	private void createNewAudio(Audio audio, AudioStream audioStream, Project project) {
		Audio newAudio = new Audio();
		newAudio.setFileName(audio.getFileName());
		newAudio.setEnabled(true);
		newAudio.setAudioStream(audioStream);
		
		audioDAO.save(newAudio);
		newAudio.getAudioStream().setAudio(newAudio);
		audioStreamDAO.save(newAudio.getAudioStream());
		
		ProjectAudio projectAudio = new ProjectAudio();
		projectAudio.setAudio(newAudio);
		projectAudio.setProject(project);
		
		projectAudioDAO.save(projectAudio);
	}

	private void removeAudioStream(Audio audio) {
		audioStreamDAO.removeByAudioId(audio.getId());
		
	}

	private void removeAudio(Audio audio) {
		audioDAO.removeById(audio.getId());
		
	}

	private void removeAllAudioRequests(Audio audio) {
		audioDAO.removeAllAudioRequests(audio.getId());
		
	}

	private void removeAudioProject(Audio audio) {
		audioDAO.removeAudioProject(audio.getId());
		
	}

	private void removeAllAudioUsers(Audio audio) {
		audioDAO.removeAllAudioUser(audio.getId());
		
	}

}
