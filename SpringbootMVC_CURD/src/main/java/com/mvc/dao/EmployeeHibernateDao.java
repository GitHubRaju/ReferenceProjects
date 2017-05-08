package com.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.model.Employee;

@Repository
public class EmployeeHibernateDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void saveEmployee(Employee employee)
	{
		System.out.println("employee id from dao  :"+employee.toString());
		hibernateTemplate.saveOrUpdate(employee);
	}
	
	public List<Employee> getAll()
	{
		return (List<Employee>) hibernateTemplate.find(" from Employee");
	}
	
	@Transactional
	public void updateEmployee(Employee emp)
	{
		hibernateTemplate.update(emp);
	}
	@Transactional
	public void deleteEmployee(Employee emp)
	{
		System.out.println("empId  :"+emp.getEmpId());
		hibernateTemplate.delete(emp);
	}
	
	public Employee getById(int empId)
	{
		return hibernateTemplate.get(Employee.class, empId);
	}
}
