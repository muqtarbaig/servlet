package org.sample.vo;

//@XmlRootElement (name = "employee")
//@XmlAccessorType(XmlAccessType.NONE)
public class Employee {

	//@XmlElement
	private int id;
	
	 //@XmlElement
	private String name;
	
	public Integer getId() {
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
	
	@Override
	public boolean equals(Object obj) {
		return this.id == ((Employee)obj).getId();
	}
	
	@Override
	public int hashCode() {
		return 100+this.id;
	}
}
