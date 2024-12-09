package com.Student.dto;

//POJO class -plain old java object- encapsulation class
//class name should be the object that must be created
//this class will have instance variables,getters and setters and toString
public class Student {
	//instance variables are all the columns of database
	private int id;
	private String name;
	private long phone;
	private String mail_id;
	private String branch;
	private String location;
	private String password;
	private String date;
	
	//generate getters and setters
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", mail_id=" + mail_id + ", branch="
				+ branch + ", location=" + location + "]";
	}
	
	
	
	
	

}

