package org.sample.equalhashcode;

public class Employee {

	private int id;
	private String skill;
	
	Employee(int id, String skill) {
		this.id = id;
		this.skill = skill;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String name) {
		this.skill = name;
	}
	
	@Override
	public String toString() {
		return id + " " + skill;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return false;
	}
}
