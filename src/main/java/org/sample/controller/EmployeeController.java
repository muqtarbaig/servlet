package org.sample.controller;

import org.sample.example.h2.Employee;
import org.sample.example.h2.EmployeeDao;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@RequestMapping(value = "/employee")
	public  Employee getEmp(){
		Employee emp = new Employee();
		emp.setId(1001);
		emp.setName("EMP-1");
		return emp;
	}

	@RequestMapping(value = "/employee.x")
	public String getEmpn(){
		Employee emp = new Employee();
		emp.setId(1001);
		emp.setName("EMP-1");
		
		return "emph";
	}
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String addEmp(/*@RequestBody Employee emp*/){
		Employee emp = new Employee();
		emp.setId(001);
		emp.setName("Emp_001");
		EmployeeDao dao = new EmployeeDao();
		dao.saveEmployee(emp);
		return "Added Emp";
	}
	
}
