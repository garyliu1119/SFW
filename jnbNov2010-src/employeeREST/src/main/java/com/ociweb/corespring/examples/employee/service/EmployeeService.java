package com.ociweb.corespring.examples.employee.service;


import com.ociweb.corespring.examples.employee.domain.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	
	public Employee getEmployee(long id);

	public void updateEmployee(Employee emp);

	public void deleteEmployee(Employee employee);
}
