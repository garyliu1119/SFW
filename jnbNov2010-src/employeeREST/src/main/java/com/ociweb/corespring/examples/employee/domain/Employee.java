package com.ociweb.corespring.examples.employee.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	private Date hireDate;
	private String jobTitle;
	
	public Employee() {
		super();
	}
	public Employee(String firstName, String lastName, String address,
			String city, String state, String zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		map.put("address", address);
		map.put("city", city);
		map.put("state", state);
		map.put("zip", zip);
		return map;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip(){
		return zip;
	}
	
	public void setZip(String zip){
		this.zip = zip;
	}

	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Override
	public String toString() {
		return "Employee [address=" + address + ", city=" + city
				+ ", firstName=" + firstName + ", hireDate=" + hireDate
				+ ", id=" + id + ", jobTitle=" + jobTitle + ", lastName="
				+ lastName + ", state=" + state + ", zip=" + zip + "]";
	}
	
	
	
}
