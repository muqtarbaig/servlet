package org.sample.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "EID")
	@JsonProperty("id")
	private int id;
	
	@Column(name = "ename")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "deptid")
	@JsonProperty("deptid")
	private int deptid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
	@Override
	public String toString() {
		return "id : " + id + " ename : " +name + " deptid : "+deptid;
	}
}
