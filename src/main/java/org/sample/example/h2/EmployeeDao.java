package org.sample.example.h2;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

@Transactional
public class EmployeeDao implements IEmployeeDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void saveEmployee(Employee emp) {
		
		hibernateTemplate.save(emp);
		
	}

}
