package com.springjdbc.jdbctemplate;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.jdbctemplate.dao.StudentDao;
import com.springjdbc.jdbctemplate.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.springjdbc.jdbctemplate.dao"})
public class JdbcConfig {

	@Bean(name = {"ds"})
	public DataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Ashish@123");

		return ds;

	}

	@Bean(name= {"jdbctemplate"})
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}

//	@Bean(name="studentDao")
//	public StudentDao getStudentDao() {
//		StudentDaoImpl studentDao = new StudentDaoImpl();
//		studentDao.setJdbcTemplate(getJdbcTemplate());
//		return studentDao;
//	}
}
