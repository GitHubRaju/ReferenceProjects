package com.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.curd.pojo.Student;
import com.curd.service.StudentService;

@Controller
public class StudentController 
{
	@Autowired
	private StudentService service;
	
	@RequestMapping("welcome")
	public ModelAndView welcomePage()
	{
		List<Student> studentList=service.getAllStudent();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("student");
		mav.addObject("student", new Student());
		mav.addObject("studentList", studentList);
		return mav;
	}
	
	@RequestMapping("saveStudent")
	public ModelAndView saveStudent(Student student)
	{
		service.saveStudent(student);
		List<Student> studentList=service.getAllStudent();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("student");
		mav.addObject("student", new Student());
		mav.addObject("studentList", studentList);
		return mav;
	}
	
	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(Student student)
	{
		
	//	service.updateStudent(student);
		List<Student> studentList=service.getAllStudent();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("student");
		mav.addObject("student", new Student());
		mav.addObject("studentList", studentList);
		return mav;
	}
	
	@RequestMapping("getById")
	public ModelAndView getStudentById(Integer student)
	{
	
	Student student1=service.getStudentById(student);
		System.out.println("---------------------------------------------");
		System.out.println(student1.getName());
		System.out.println(student1.getSid());
		System.out.println(student1.getEmail());
	System.out.println("---------------------------------------------------------");
	ModelAndView mav=new ModelAndView();
	mav.setViewName("student");
	mav.addObject("student",student1);
	return mav;
	}
	
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(Student student)
	{
		service.deleteStudent(student);
		List<Student> studentList=service.getAllStudent();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("student");
		mav.addObject("student", new Student());
		mav.addObject("studentList", studentList);
		return mav;
	}
	
	@RequestMapping("editStudent")
	public ModelAndView editStudent(Integer student)
	{
		System.out.println(student);
	Student student1=service.getStudentById(student);
		List<Student> studentList=service.getAllStudent();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("student");
		mav.addObject("student", student1);
		mav.addObject("studentList", studentList);
		return mav;
	}
	
}
