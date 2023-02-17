package com.sonia.secureapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sonia.secureapp.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		// inserting Student
		int status = 0;
		String query = "INSERT INTO student (id, name, city) VALUES (?, ?, ?)";
		status = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return status;
	}

	@Override
	public int update(Student student) {
		// Updating Student
		int status = 0;
		String query = "update student set name=?, city=? where id=?";
		status = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());

		return status;
	}

	@Override
	public int delete(int studentId) {
		// deleting student

		int status = 0;
		String query = "delete from student where id=?";
		status = this.jdbcTemplate.update(query, studentId);
		return status;
	}

	@Override
	public Student getStudent(int studentId) {

		// Single select query
		Student student = null;

		String query = "select * from student where id=?";

		RowMapper<Student> rowMapper = new RowMapperImpl();
		student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);

		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		// multiple select

		List<Student> studentList = null;

		String query = "select * from student";

		RowMapper<Student> rowMapper = new RowMapperImpl();

		studentList = this.jdbcTemplate.query(query, rowMapper);

		return studentList;
	}

}
