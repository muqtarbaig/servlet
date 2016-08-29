package org.sample.hibernate;

public interface IEmployeeDao {
	
	public void saveEmployee(Employee emp);
	
	public Employee getEmployee(int id);
	
	public void deleteEmployee(int id);
	
}
