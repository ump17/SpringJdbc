package com.springjdbc.jdbctemplate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.jdbctemplate.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int update = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getAddress());
		return update;
	}
	
	@Override
	public int change(Student student) {
		//sequence of student.get() is imp here
		String query = "update student set name=?, city=? where id=?";
		int update = this.jdbcTemplate.update(query,student.getName(),student.getAddress(),student.getId());
		return update;
	}
	
	@Override
	public int delete(Student student) {
		String query = "DELETE FROM student WHERE id=?";
		int deleted = this.jdbcTemplate.update(query,student.getId());
		return deleted;
	}
	
	@Override
	public Student getStudent(int studentId) {
		//select single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper ,studentId);
		return student;
	}
	
	@Override
	public List<Student> getAllStudents() {
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
