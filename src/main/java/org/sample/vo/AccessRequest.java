package org.sample.vo;

import java.util.List;

public class AccessRequest {

	private String name;
	private int age;
	private String state;
	private List<Channel> reqChannels;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Channel> getRequestChannels() {
		return reqChannels;
	}
	public void setRequChannels(List<Channel> setChannels) {
		this.reqChannels = setChannels;
	}
	
	@Override
	public String toString() {
		
		String request = "Name: " +this.name + "State: "+this.state + "age: "+this.age 
						+ "Channels: "+this.reqChannels;
		
		return request;
	}
}
