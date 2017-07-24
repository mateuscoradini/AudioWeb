package com.privates.audio.web.repository;

import java.util.List;

import com.privates.audio.web.entity.User;

public interface UserDAO {

	User findById(Long id);

	int save(User user);

	User findByUsername(String username);

	void delete(User user);

	List<User> findAll();

}
