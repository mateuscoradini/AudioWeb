package com.privates.audio.web.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCBaseDAO {
	
	 /**
     * Injected by Spring
     *
     * @see <code>applicationContext.xml/dataSource.xml</code>
     */
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    
    
    /**
     * Injected by Spring
     *
     * @see <code>applicationContext.xml/dataSource.xml</code>
     */
    @Autowired
    @Qualifier("namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	public DataSource getDataSource() {
		return dataSource;
	}


	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

}
