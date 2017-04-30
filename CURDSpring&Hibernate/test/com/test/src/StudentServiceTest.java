package com.test.src;

import org.junit.Test;

import com.curd.pojo.Student;
import com.curd.service.StudentService;

public class StudentServiceTest {

	//@Test
	public void deleteTest()
	{
		Student student=new Student();
		student.setSid(1);
		student.setEmail("abcd@gmail.com");
		student.setName("naresh");
		StudentService service=(StudentService)TestUtils.getObject("studentService");
		service.deleteStudent(student);
	}
	@Test
	public void getByIdTest()
	{
		Student student=new Student();
		student.setSid(2);
		StudentService service=(StudentService)TestUtils.getObject("studentService");
	Student stu=	service.getStudentById(student);
	System.out.println(stu.getName());
	}
}
