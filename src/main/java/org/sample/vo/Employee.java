package org.sample.vo;

//@XmlRootElement (name = "employee")
//@XmlAccessorType(XmlAccessType.NONE)
public class Employee {

	//@XmlElement
	private int id;
	
	 //@XmlElement
	private String name;
	
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
	
	
}
