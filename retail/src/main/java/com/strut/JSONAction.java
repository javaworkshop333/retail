package com.strut;

import org.springframework.beans.factory.annotation.Autowired;

import com.hibernate.LoginEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.spring.beans.ProfileBean;

public class JSONAction  extends ActionSupport{
	// form action request input
	public String userid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}	
	// business method
	@Autowired
	public ProfileBean profile;
	public String execute()
	{ 
		LoginEntity le=profile.findUser(userid);
		if(le!=null) {
			firstName=le.getFirstName();
			lastName=le.getLastName();
		}
		else {
			userid="user not found";
		}
		return "success";
	}
	// Response json
	public String firstName;
	public String lastName;
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

}
