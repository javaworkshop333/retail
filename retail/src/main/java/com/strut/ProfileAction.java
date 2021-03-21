package com.strut;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.spring.beans.ProfileBean;

public class ProfileAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	// UI FORM DATA
	public String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String password;
	public String fname;
	public String lname;

	// UI FORM DATA

	// SPRING DEPENDANCY INJECTION
	@Autowired
	public ProfileBean profile;
	// SPRING DEPENDANCY INJECTION

	public String register() throws Exception {
		try {
			profile.register(userid, password, fname, lname);
			System.out.println("returning success");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("returning failure");
			return ERROR;
		}

	}

	public String delete() throws Exception {
		try {
			boolean deletedRecords=profile.delete(userid);
			if(deletedRecords)
			{
				inputStream = new StringBufferInputStream("successfully deleted");
				return SUCCESS;
			}
			else
			{
				inputStream = new StringBufferInputStream("failed deletion");
				return SUCCESS;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			inputStream = new StringBufferInputStream("failed deletion");
			return SUCCESS;
		}
	}

	public String update() throws Exception {
		try {
			boolean updatedRecords=profile.update(userid,password);
			if(updatedRecords)
			{
				inputStream = new StringBufferInputStream("successfully updated");
				return SUCCESS;
			}
			else
			{
				inputStream = new StringBufferInputStream("failed updation");
				return SUCCESS;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			inputStream = new StringBufferInputStream("failed updation");
			return SUCCESS;
		}
	}

}