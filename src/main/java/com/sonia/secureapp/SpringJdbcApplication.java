package com.sonia.secureapp;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sonia.secureapp.dao.StudentDao;
import com.sonia.secureapp.dao.StudentDaoImpl;
import com.sonia.secureapp.entity.Student;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		System.out.println("My program started...");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sonia/secureapp/config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDaoImpl.class);

//		// insert query
		Student student = new Student();
		student.setId(110);
		student.setName("Milan BAmaniya");
		student.setCity("Mumbai");

		studentDao.update(student);

		List<Student> studentList = null;

		studentList = studentDao.getAllStudent();

		System.out.println("Number of rows affected, " + studentList);

	}

}
