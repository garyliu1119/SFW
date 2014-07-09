package com.ociweb.corespring.examples.employee.rest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ociweb.corespring.examples.employee.domain.Employee;

public class EmployeeRegistrationService {
	private final String SERVICE_URL;
	private final String SERVICE_URL_TEMPLATE;
	
	private final RestTemplate template;
	private final RestTemplate templateNoErrorHandling;
	
	public EmployeeRegistrationService(String serviceURL, RestTemplate template, 
			RestTemplate templateNoErrorHandling) {
		SERVICE_URL = serviceURL;
		SERVICE_URL_TEMPLATE = SERVICE_URL + "{id}";
		this.template = template;
		this.templateNoErrorHandling = templateNoErrorHandling;
	}
	

	public Employee getEmployee(long id){
		try {
			return template.getForObject(SERVICE_URL_TEMPLATE, Employee.class, id);
			
		} catch(Exception e){
			e.printStackTrace(); 
			return null;
		}
	}
	
	public Employee createEmployee(Employee emp){
		try {
			return template.postForObject(SERVICE_URL, emp, Employee.class);
		
		} catch(Exception e){
			e.printStackTrace(); 
			return null;
		}
	}
	
	public boolean updateEmployee(Employee emp) {
		try {
			template.put(SERVICE_URL_TEMPLATE, emp, emp.getId());
			return true;
			
		} catch(Exception e){
			e.printStackTrace(); 
			return false;
		}
	}
	
	public boolean deleteEmployee(long id){
		try {
			template.delete(SERVICE_URL_TEMPLATE, id);
			return true;
			
		} catch(Exception e){
			e.printStackTrace(); 
			return false;
		}
	}
	
	public Employee createEmployee2(Employee emp){
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(emp);
		ResponseEntity<Object> response = 
			templateNoErrorHandling.exchange(SERVICE_URL, HttpMethod.POST, 
					requestEntity, Object.class);
		if(response.getStatusCode() == HttpStatus.OK){
			return  (Employee)response.getBody();
		} 
			
		ResultMessage rm = (ResultMessage) response.getBody();
        System.out.println(rm.getMessage()); 
		return null;
	}
	
}
