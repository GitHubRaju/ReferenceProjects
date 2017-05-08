package com.mvc.jdbcmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.mvc.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee employee=new Employee();
		employee.setEmpId(rs.getInt(1));
		employee.setEmpAdd(rs.getString(2));
		employee.setEmpName(rs.getString(3));
		return employee;
	}

}
