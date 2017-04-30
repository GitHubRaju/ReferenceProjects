package com.curd.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.curd.pojo.Student;
@Component
public class StudentDaoImpl implements StudentDao
{
	@Autowired
	private HibernateTemplate template;
	@Transactional
	public void saveStudent(Student student) {
	template.save(student);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		
		return (List<Student>)template.find("from Student");
	}


	@Transactional
	public void deleteStudent(Student student) 
	{
		System.out.println(student.getSid());
	template.delete(student);
		System.out.println("delete");
	}

	@Override
	public Student getStudentById(Integer student) {
		System.out.println("from dao etbyid"+student);
		return (Student)template.get(Student.class, student);
	}

	
	@Transactional
	public void updateStudent(Student student) {
	template.saveOrUpdate(student);
	}

	@Override
	public void updateStudent(Integer student) {
		// TODO Auto-generated method stub
		
	}

	

}
