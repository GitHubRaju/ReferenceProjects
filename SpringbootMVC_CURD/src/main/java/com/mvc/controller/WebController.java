package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.dao.EmployeeHibernateDao;
import com.mvc.dao.EmployeeJdbcDao;
import com.mvc.model.Employee;
import com.mvc.repository.EmployeeRepository;

@RestController
public class WebController {

	@Autowired
	private EmployeeHibernateDao empHibernatedao;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeJdbcDao empJdbcDao;

	@ModelAttribute
	public Employee createEmployee(){
		return new Employee();
	}
	
	@RequestMapping("/index")
	public ModelAndView wellcomePage()
	{
		List<Employee> empList=empHibernatedao.getAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("empList", empList);
		mav.setViewName("index");
		return mav; 
	}
	
	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		System.out.println(employee.toString());
		
		//employeeRepository.save(employee);//spring data repository
		//List<Employee> empList=employeeRepository.findAll();//repository
		
		//empHibernatedao.saveEmployee(employee);//hibernate
		//List<Employee> empList=empHibernatedao.getAll();//hibernate template
	
		empJdbcDao.saveEmployee(employee);//jdbc template
		List<Employee> empList = empJdbcDao.getAllEmployee();//Jdbctemplate

		ModelAndView mav = new ModelAndView();
		mav.addObject("empList", empList);
		mav.addObject("wish", "Wellcome Employee world");
		mav.setViewName("index");
		return mav;
	}


	@RequestMapping("/getEmployeeToUpadte")
	public ModelAndView getempTOupdateEmployee(@RequestParam("id") int empId) {
		
		//Employee employee = empHibernatedao.getById(empId);//hibernate template
		//List<Employee> empList=empHibernatedao.getAll();//hibernate template
		
		//Employee employee=employeeRepository.findOne(empId);//repository
		//List<Employee> empList=employeeRepository.findAll();//repository
		System.out.println("EEMPID :"+empId);
		Employee employee=empJdbcDao.findByEmpId(empId);//jdbc template
		List<Employee> empList = empJdbcDao.getAllEmployee();//Jdbctemplate
		ModelAndView mav = new ModelAndView();
		mav.addObject("employee", employee);
		mav.addObject("empList", empList);
		mav.setViewName("index");
		return mav;

	}
	@RequestMapping("/upadteEmployee")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		empHibernatedao.updateEmployee(employee);
		List<Employee> empList=empHibernatedao.getAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("empList", empList);
		mav.setViewName("index");
		return mav;

	}
	
	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("id")int empId)
	{
		System.out.println("empid  :  "+empId);
		Employee employee=new Employee();
		employee.setEmpId(empId);
		//empHibernatedao.deleteEmployee(employee);//hibernate template
		//List<Employee> empList=empHibernatedao.getAll();//hibernate template
		
		//employeeRepository.delete(employee);//repository
		//List<Employee> empList=employeeRepository.findAll();//repository
		
		empJdbcDao.deleteEmployee(employee);//jdbc template
		List<Employee> empList = empJdbcDao.getAllEmployee();//Jdbctemplate
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("empList", empList);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/get")
	public ModelAndView get(@RequestParam("name")String name)
	{
	System.out.println(name);
		ModelAndView mav=new ModelAndView();
		mav.addObject("name",name.toUpperCase());
		mav.setViewName("index");
		return mav;
	}
}
