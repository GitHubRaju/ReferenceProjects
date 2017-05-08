package com.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.jdbcmapper.EmployeeMapper;
import com.mvc.model.Employee;

@Repository
public class EmployeeJdbcDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void saveEmployee(Employee employee)
	{
		String insertquery="insert into employee values(?,?,?)";
		try{
		jdbcTemplate.update(insertquery,new Object[]{employee.getEmpId(),employee.getEmpName(),employee.getEmpAdd()});
		}catch(Exception e)
		{
			updateEmployee(employee);
		}
		}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		
		String selectQuery="select * from employee";
		 List<Employee> empList=jdbcTemplate.query(selectQuery,new EmployeeMapper());
		 
		 return empList;
	}
	
	public Employee findByEmpId(int empId)
	{
		String sql="select * from employee where empId=?";
		return jdbcTemplate.queryForObject(sql, new EmployeeMapper(),empId);
	}
	
	@Transactional
	public void updateEmployee(Employee employee)
	{
		String sql1="update employee set empName=?,empAdd=? where empId=?";
		jdbcTemplate.update(sql1, employee.getEmpName(),employee.getEmpAdd(),employee.getEmpId());
		
	}
	
	@Transactional
	public void deleteEmployee(Employee employee)
	{
		String sql="delete from employee where empId=?";
		jdbcTemplate.update(sql,employee.getEmpId());
	}
}
