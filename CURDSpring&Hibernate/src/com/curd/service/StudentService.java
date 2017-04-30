package com.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curd.dao.StudentDao;
import com.curd.pojo.Student;

@Component
public class StudentService 
{
	@Autowired
	private StudentDao dao;
	
	public void saveStudent(Student student)
	
	{
		dao.saveStudent(student);
	}
	
	public void  deleteStudent(Student student)
	{
		dao.deleteStudent(student);
	}
	
	public List<Student> getAllStudent()
	{
		return dao.getAllStudent();
		
	}
	
	public Student getStudentById(Integer student)
	{
		return dao.getStudentById(student);
	}
	public void updateStudent(Integer student)
	{
		dao.updateStudent(student);
	}
}
