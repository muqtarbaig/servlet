package org.sample.controller;

import org.sample.vo.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
