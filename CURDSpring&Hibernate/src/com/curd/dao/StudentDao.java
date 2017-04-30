package com.curd.dao;

import java.util.List;

import com.curd.pojo.Student;

public interface StudentDao 
{

	public void saveStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public void deleteStudent(Student student);
	
	public Student getStudentById(Integer student);
	
	public void updateStudent(Integer student);
}
