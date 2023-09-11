package com.springjdbc.jdbctemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.jdbctemplate.dao.StudentDao;
import com.springjdbc.jdbctemplate.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Program started.....");

//        ApplicationContext context = 
//        		new ClassPathXmlApplicationContext("com/springjdbc/jdbctemplate/config.xml");
//        JdbcTemplate template = context.getBean("jdbctemplate",JdbcTemplate.class);       
//        //insert query
//        String query="insert into student(id,name,city) values(?,?,?)";       
//        template.update(query,24,"Akki","Ahmednagar");       
//        System.out.println("Task Completed.");

//		ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/jdbctemplate/config.xml");
//		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		// Insert
//        Student student = new Student();
//        student.setId(18);
//        student.setName("Ashish Sengar");
//        student.setAddress("Pune");
//        
//        int insert = studentDao.insert(student);
//        System.out.println( "Row Inserted successfully....."+insert );

		// update
//        Student student1 = new Student();
//        student1.setId(17);
//        student1.setName("Ashish Singh Sengar");
//        student1.setAddress("Delhi");
//        int update = studentDao.change(student1);
//        System.out.println( "Row Updated successfully....."+update );

		// Delete
//        Student student2 = new Student();
//        student2.setId(18);
//        int deleted = studentDao.delete(student2);
//        System.out.println( "Row Deleted successfully....."+deleted );

		// select single object
//        Student student = studentDao.getStudent(17);
//        System.out.println( "Single Row Fetched successfully  => "+student );

		// select * query
		// sysout - control+ space
//		List<Student> allStudents = studentDao.getAllStudents();
//		System.out.println("Students registered are:");
//		for (Student s : allStudents) {
//			System.out.println(s);
//		}
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		List<Student> allStudents = studentDao.getAllStudents();
		System.out.println("Students registered are:");
		for (Student s : allStudents) {
			System.out.println(s);
		}
	}
}
