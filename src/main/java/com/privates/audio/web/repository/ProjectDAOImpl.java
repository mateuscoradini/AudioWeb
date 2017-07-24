package com.privates.audio.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.privates.audio.web.entity.Project;
import com.privates.audio.web.repository.mapper.ProjectRowMapper;

@Component
public class ProjectDAOImpl extends JDBCBaseDAO implements ProjectDAO {
	
	
	public static final String FIND_ALL_QUERY = "SELECT * FROM tb_project";
	
	public static final String FIND_BY_PROJECT_NAME_QUERY = "SELECT * FROM tb_project t where t.name = :PROJECT_NAME";
	
	public static final String FIND_BY_PROJECT_ID_QUERY = "SELECT * FROM tb_project t where t.id = :ID";
	
	public static final String INSERT_QUERY = "INSERT INTO tb_project (name, scope, enabled, insert_date) VALUES (:NAME, :SCOPE, :ENABLED, :INSERT_DATE)";
	
	public static final String DELETE_PROJECT_BY_ID_QUERY = "DELETE from tb_project where id = :ID ";
	

	@Override
	public List<Project> findAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		return this.getNamedParameterJdbcTemplate().query(FIND_ALL_QUERY, map, new ProjectRowMapper());		
	}

	@Override
	public int save(Project project) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("NAME", project.getName());
		mapSql.addValue("SCOPE", project.getScope());
		mapSql.addValue("ENABLED", 1);
		mapSql.addValue("INSERT_DATE", project.getInsertDate());

		try {
			this.getNamedParameterJdbcTemplate().update(INSERT_QUERY, mapSql, keyHolder, new String[] { "ID" });
		} catch (Exception e) {
			return 0;
		}

		project.setId(keyHolder.getKey().longValue());
		return 1;
	}

	@Override
	public Project findByName(String projectName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PROJECT_NAME", projectName);
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_BY_PROJECT_NAME_QUERY, map, new ProjectRowMapper());	
	}

	@Override
	public Project findById(Long projectId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID", projectId);
		return this.getNamedParameterJdbcTemplate().queryForObject(FIND_BY_PROJECT_ID_QUERY, map, new ProjectRowMapper());	
	}

	@Override
	public int removeById(long projectID) {		

		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("ID", projectID);

		try {
			this.getNamedParameterJdbcTemplate().update(DELETE_PROJECT_BY_ID_QUERY, mapSql);
		} catch (Exception e) {
			return 0;
		}
		return 1;
		
	}

}
