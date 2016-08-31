package org.sample.hibernate;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.sample.exception.ProgramException;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class EmployeeDao implements IEmployeeDao{

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee emp) {
		try {
		sessionFactory.getCurrentSession().save(emp);
		}catch (Exception ex) {
			throw new ProgramException(910, "DB", ex.getMessage());
		}
	}

	@Override
	public Employee getEmployee(int id) {
		try{
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
		}catch (Exception ex) {
		throw new ProgramException(911, "DB", ex.getMessage());
		}
	}

	@Override
	public void deleteEmployee(int id) {
		sessionFactory.getCurrentSession().delete(getEmployee(id));
		throw new ProgramException(910, "DB", "ex.getMessage()");
	}

}
