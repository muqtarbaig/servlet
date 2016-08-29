package org.sample.hibernate;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class EmployeeDao implements IEmployeeDao{

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public Employee getEmployee(int id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public void deleteEmployee(int id) {
		sessionFactory.getCurrentSession().delete(getEmployee(id));
	}

}
