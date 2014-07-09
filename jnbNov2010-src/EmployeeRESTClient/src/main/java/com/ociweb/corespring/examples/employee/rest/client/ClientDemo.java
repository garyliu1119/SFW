package com.ociweb.corespring.examples.employee.rest.client;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ociweb.corespring.examples.employee.domain.Employee;

public class ClientDemo {


	public static void main(String[] args) {
		ApplicationContext ac = 
			new AnnotationConfigApplicationContext(RESTConfig.class);
		
		EmployeeRegistrationService service = 
			ac.getBean(EmployeeRegistrationService.class);
		
		//happy path
		Employee e1 = new Employee();
		e1.setFirstName("John");
		e1.setLastName("smith");
		e1.setAddress("105 Easy St.");
		e1.setCity("Saint Louis");
		e1.setJobTitle("Programmer");
		e1.setHireDate(new Date());
		e1.setState("MO");
		e1.setZip("63101");
		
		e1 = service.createEmployee2(e1);
		System.out.println(e1.toString());
		
		
		Employee emp = service.getEmployee(e1.getId());
		System.out.println(emp.toString());
		
		//update
		emp.setFirstName("Jim");
		service.updateEmployee(emp);
		emp = service.getEmployee(emp.getId());
		System.out.println(emp.toString());
		
		//delete
		service.deleteEmployee(emp.getId());
		System.out.println("deleted employee: " + emp.getId());		
		
		//unhappy path
		System.out.println("UNHAPPY PATH 1:");
		emp = new Employee();
		emp = service.createEmployee(emp); 
		if(emp == null){
			System.out.println("employee not created\n");
		}

		//unhappy path
		System.out.println("UNHAPPY PATH 2:");
		emp = new Employee();
		emp = service.createEmployee2(emp); 
		if(emp == null){
			System.out.println("employee not created\n");
		}
		
	}

}
