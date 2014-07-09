package com.ociweb.corespring.examples.employee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ociweb.corespring.examples.employee.domain.Employee;

@Repository
public class EmployeeHibernateDao implements EmployeeDao{
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		session().saveOrUpdate(employee);	
	}
	
	public Employee retrieveEmployee(long id) {
		return (Employee) session().get(Employee.class, id);
	}
	
	public void updateEmployee(Employee emp) {
		session().saveOrUpdate(emp);
	}
	
	public void deleteEmployee(Employee employee){
		session().delete(employee);
	}
	
	private Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
