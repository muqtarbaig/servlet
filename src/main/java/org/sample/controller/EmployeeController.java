package org.sample.controller;

import org.sample.hibernate.Employee;
import org.sample.hibernate.IEmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	
	@Autowired private IEmployeeDao dao;
	
	@RequestMapping(value = "/employee/remove/{eid}") // http://localhost:9090/sampleserv/employee/remove/8
	public void getEmp(@PathVariable("eid") int id){
		dao.deleteEmployee(id);
	}

	@RequestMapping(value = "/employee/get/{eid}") // http://localhost:9090/sampleserv/employee/get/1
	public Employee getEmpn(@PathVariable("eid") int id){
		return dao.getEmployee(id);
	}
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST) // http://localhost:9090/sampleserv/employee/add?id=8&name=Hasheem&deptid=2
	public String addEmp(/*@RequestBody Employee emp*/@RequestParam(value = "id") int id, 
			@RequestParam("name") String name, @RequestParam("deptid") int deptid){
			Employee emp = new Employee();
			emp.setId(id);
			emp.setName(name);
			emp.setDeptid(deptid);
			//		EmployeeDao dao = new EmployeeDao();
			dao.saveEmployee(emp);
		return "Added Emp";
	}
	
	@RequestMapping(value = "/employee/addemp", method = RequestMethod.POST) // http://localhost:9090/sampleserv/employee/add?id=8&name=Hasheem&deptid=2
	public String addEmpFromJson(@RequestBody Employee emp){
		System.out.println("emp is "+emp);
			dao.saveEmployee(emp);
		return "Added Emp";
	}
	
	
	
}
