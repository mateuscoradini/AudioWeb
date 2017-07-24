package com.privates.audio.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.AudioRole;
import com.privates.audio.web.entity.Project;
import com.privates.audio.web.entity.ProjectAudio;
import com.privates.audio.web.entity.Role;
import com.privates.audio.web.entity.User;
import com.privates.audio.web.repository.AudioDAO;
import com.privates.audio.web.repository.AudioRoleDAO;
import com.privates.audio.web.repository.ProjectAudioDAO;
import com.privates.audio.web.repository.ProjectDAO;
import com.privates.audio.web.repository.RoleDAO;
import com.privates.audio.web.repository.UserDAO;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@Autowired
	private AudioDAO audioDAO;
	
	@Autowired
	private AudioRoleDAO audioRoleDAO;
	
	@Autowired
	private ProjectAudioDAO projectAudioDAO;

	public User findById(Long id) {
		User user = userDAO.findById(id);
		// List<Role> list = roleRepository.findByUsers(user, new PageRequest(0,
		// 10, Direction.DESC, "id"));
		// user.setListRoles(list);
		return user;
	}

	public void save(User user) {

		List<Role> roleList = roleDAO.findUserRole();// .findAll();

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = user.getPassword();
		user.setPassword(encoder.encode(password));
		user.setEnabled(true);

		List<Role> userRoles = new ArrayList<Role>();
		userRoles.addAll(roleList);
		user.setListRoles(userRoles);

		userDAO.save(user);
		for (Role userRole : user.getListRoles()) {
			roleDAO.save(userRole, user);
		}

	}

	public User findByName(String username) {
		User user = userDAO.findByUsername(username);
		return findById(user.getId());
	}

	public void removeById(Long id) {
		User user = findById(id);
		boolean admin = false;
		for (Role role : user.getListRoles()) {
			if (role.getName().equals("ROLE_ADMIN")) {
				admin = true;
			}
		}
		if (!admin) {
			userDAO.delete(user);
		}

	}

	public List<User> findAll() {
		return userDAO.findAll();
	}

	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	public List<User> findAllAudioRequests() {
		
		List<User> list = new ArrayList<User>();
		List<AudioRole> listAudioRole = audioRoleDAO.findAll();
		
		for(AudioRole audioRole : listAudioRole){
			Audio audio = audioDAO.findById(audioRole.getAudio().getId());
			ProjectAudio projectAudio = projectAudioDAO.findByAudio(audioRole.getAudio().getId());
			Project project = projectDAO.findById(projectAudio.getProject().getId());			
			User user = userDAO.findById(audioRole.getUser().getId());
			
			user.setAudio(audio);
			user.setProject(project);
			user.setAudioRole(audioRole);
			list.add(user);
			
		}
		
		return list;
	}

}
