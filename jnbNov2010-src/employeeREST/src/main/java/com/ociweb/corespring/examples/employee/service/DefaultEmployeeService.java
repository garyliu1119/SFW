package com.ociweb.corespring.examples.employee.service;

import com.ociweb.corespring.examples.employee.dao.EmployeeDao;
import com.ociweb.corespring.examples.employee.domain.Employee;

public class DefaultEmployeeService implements EmployeeService {
	private EmployeeDao dao;

	public void addEmployee(Employee employee) {
		dao.addEmployee(employee);	
	}
	
	public Employee getEmployee(long id) {
		return dao.retrieveEmployee(id);
	}
	
	public void updateEmployee(Employee emp) {
		dao.updateEmployee(emp);
	}
	
	public void deleteEmployee(Employee employee) {
		dao.deleteEmployee(employee);
	}	
	
	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
}
