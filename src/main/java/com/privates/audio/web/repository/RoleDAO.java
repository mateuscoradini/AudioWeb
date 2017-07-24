package com.privates.audio.web.repository;

import java.util.List;

import com.privates.audio.web.entity.Role;
import com.privates.audio.web.entity.User;

public interface RoleDAO {

	List<Role> findAll();

	List<Role> findUserRole();

	int save(Role userRole, User user);

}
