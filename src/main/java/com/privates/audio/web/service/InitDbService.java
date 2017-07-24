package com.privates.audio.web.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class InitDbService {

//	@Autowired
//	private ApplicationContext applicationContext;
//
//	@Autowired
//	private RoleRepository roleRepository;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private ProjectRepository projectRepository;
//
//	@Autowired
//	private AudioRepository audioRepository;

	@PostConstruct
	public void initializeDataBase() {
//		applicationContext.getBean("entityManagerFactory");
//
//		/** Admin User */
//		Set<Role> roles = new HashSet<Role>();
//		Role role = new Role();
//		role.setName("ROLE_USER");
//		Role role2 = new Role();
//		role2.setName("ROLE_ADMIN");
//		roles.add(role);
//		roles.add(role2);
//
//		roleRepository.save(roles);
//
//		Set<User> users = new HashSet<User>();
//		User user = new User();
//		user.setUsername("admin");
//		user.setName("admin");
//		user.setEmail("admin@admin.com");
//		
//		//TODO ver data no MYSQL
//		//user.setInsertDate(new java.sql.Date(new Date().getTime()));
//		user.setListRoles(roles);
//		user.setPassword("admin");
//		user.setEnabled(true);
//
//		users.add(user);
//
//		userRepository.save(users);

//		Project project = new Project();
//		project.setEnabled(true);
//		project.setInsertDate(new Date());
//		project.setName("Project One");
//		project.setScope("Scope One");
//		project.setKey("OneOne");
//		projectRepository.save(project);
//
//		Audio audio = new Audio();
//
//		//audio.setInsertDate(new Date());
//		audio.setProject(project);
//		audio.setEnabled(true);
//		audio.setListUsers(users);
//		audioRepository.save(audio);

		/** --Admin User */
	}

}
