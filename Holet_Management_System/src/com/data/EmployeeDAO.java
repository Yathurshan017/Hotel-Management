package com.data;

import java.util.List;

import com.model.Employee;


public interface EmployeeDAO {
public List<Employee> getEmployees() throws Exception;
	
//	void addItem(HttpServletRequest request) throws Exception;
	
	void addEmployee(Employee employee) throws Exception;
	
	public void deleteEmployee(int id) throws Exception;
	
	public List<Employee> searchEmployees(String fullName) throws Exception;
	
	public Employee getEmployee(int id) throws Exception;
	
	public void updateEmployee(Employee employee) throws Exception;
}
