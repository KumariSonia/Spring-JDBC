package com.sonia.secureapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sonia.secureapp.dao.StudentDao;
import com.sonia.secureapp.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = { "com.sonia.secureapp.dao" })
public class JdbcConfig {

	@Bean("ds")
	DataSource getDatasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springJdbc");
		ds.setUsername("root");
		ds.setPassword("root");

		return ds;
	}

	@Bean("jdbcTemplate")
	JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDatasource());
		return jdbcTemplate;
	}

//	@Bean("studentDao")
//	StudentDao getStudentDao() {
//
//		StudentDaoImpl studentDao = new StudentDaoImpl();
//		studentDao.setJdbcTemplate(getTemplate());
//		return studentDao;
//	}
}
