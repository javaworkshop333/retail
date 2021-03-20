package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LoginEntity {

	@Id
	@Column(name="userid")
	String uid;
	@Column(name="password")
	String pwd;	
	@Column(name="fname")
	String firstName;
	@Column(name="lname")
	String lastName;
	// uid is unqiue key in the table, need atleast a constructor with uid only.
	public LoginEntity()
	{
		
	}
	public LoginEntity(String uid)
	{
		this.uid=uid;
	}
	public LoginEntity(String uid,String pwd,String firstName,String lastName )
	{
		this.uid=uid;
		this.pwd=pwd;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	@Override
	public String toString() {
		return "LoginEntity [uid=" + uid + ", pwd=" + pwd + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
 

}
