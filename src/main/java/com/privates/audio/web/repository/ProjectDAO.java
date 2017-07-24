package com.privates.audio.web.repository;

import java.util.List;

import com.privates.audio.web.entity.Project;

public interface ProjectDAO {
	
	public List<Project> findAll();

	public int save(Project project);

	public Project findByName(String projectName);
	
	public Project findById(Long projectId);

	public int removeById(long projectID);

}
