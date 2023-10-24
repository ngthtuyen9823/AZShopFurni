package com.azshop.models;

import java.util.Date;

public class UserModel {
	private int userID;
	private String firstName;
	private String lastName;
	private String address;
	private int gender;
	private String phone;
	private Date dob;
	private String ciid;
	private int type;
	private int kpi;
	private String area;
	public UserModel() {
		super();
	}
	public UserModel(int userID, String firstName, String lastName, String address, int gender, String phone, Date dob,
			String ciid, int type, int kpi, String area) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
		this.dob = dob;
		this.ciid = ciid;
		this.type = type;
		this.kpi = kpi;
		this.area = area;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCiid() {
		return ciid;
	}
	public void setCiid(String ciid) {
		this.ciid = ciid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getKpi() {
		return kpi;
	}
	public void setKpi(int kpi) {
		this.kpi = kpi;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
