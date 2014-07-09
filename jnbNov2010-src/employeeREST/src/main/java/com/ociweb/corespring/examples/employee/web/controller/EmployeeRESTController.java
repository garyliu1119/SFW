package com.ociweb.corespring.examples.employee.web.controller;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ociweb.corespring.examples.employee.domain.Employee;
import com.ociweb.corespring.examples.employee.service.EmployeeService;

@Controller
@RequestMapping("/registration")
public class EmployeeRESTController {
	
	@Autowired
	private EmployeeService employeeService;


	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		ResponseEntity<ResultMessage> errorResponse = validateEmployee(employee);
		
		if(errorResponse != null){
			return errorResponse;
		}
		
		employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> readEmployee(@PathVariable("id") long id) {
		Employee emp = employeeService.getEmployee(id);
		if(emp != null){
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} else {
			ResultMessage resultMessage = 
				new ResultMessage(20, "Employee with id: " + id + " not found.");
			return new ResponseEntity<ResultMessage>(
					resultMessage, HttpStatus.NOT_FOUND);
		}
	}
	

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ResultMessage> updateEmployee(
			@RequestBody Employee employee){
		
		ResponseEntity<ResultMessage> errorResponse = validateEmployee(employee);
		if(errorResponse != null){
			return errorResponse;
		}
		
		employeeService.updateEmployee(employee);
		ResultMessage rm = new ResultMessage(0, "Employee update successful.");
		return new ResponseEntity<ResultMessage>(rm, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ResultMessage> deleteEmployee(
			@PathVariable("id") long id){
		
		Employee emp = employeeService.getEmployee(id);
		if(emp == null){
			ResultMessage resultMessage = 
				new ResultMessage(20, "Employee with id: " + id + " not found.");
			return new ResponseEntity<ResultMessage>(
					resultMessage, HttpStatus.NOT_FOUND);
		}
		
		employeeService.deleteEmployee(emp);
		ResultMessage rm = new ResultMessage(0, "Employee delete successful.");
		return new ResponseEntity<ResultMessage>(rm, HttpStatus.OK);
	}
	

	@RequestMapping("/serviceError")
	public ResponseEntity<ResultMessage> serverError(){
		ResultMessage resultMessage = new ResultMessage(50, 
				"An internal error occurred while processing your request.");
		return new ResponseEntity<ResultMessage>(
				resultMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public String exceptionHandler(Exception e){
		return "serviceError"; 
	}
	
	private ResponseEntity<ResultMessage> validateEmployee(Employee emp){
		if(StringUtils.isBlank(emp.getFirstName())){
			ResultMessage rm = 
				new ResultMessage(30, "Employee name is a required field.");
			return new ResponseEntity<ResultMessage>(rm, HttpStatus.BAD_REQUEST);
		}	
		return null;
	}
}
