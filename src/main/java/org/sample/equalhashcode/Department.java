package org.sample.equalhashcode;

public class Department {

	private String deptName;

	Department(String dname) {
		this.deptName = dname;
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString() {
		return deptName + " ";
	}
}
