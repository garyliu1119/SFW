package com.ociweb.corespring.examples.employee.dao;

import com.ociweb.corespring.examples.employee.domain.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee employee) ;
	
	public void updateEmployee(Employee emp);

	public Employee retrieveEmployee(long id);
	
	public void deleteEmployee(Employee employee);
}