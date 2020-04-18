package com.bdonor.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "BDonor")
@XmlType(propOrder = { "id","name", "bgroup", "gender", "age"})
public class Data {
	private int id;
	private String name;
	private String bgroup;
	private String gender;
	private int age;
	
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

	public String getBgroup() {
		return bgroup;
	}

	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Data(int id,String name, String bgroup, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.bgroup = bgroup;
		this.gender = gender;
		this.age = age;
	}
	
	
	
	
}
