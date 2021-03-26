package com.config;

public class Connection {
	public String userid;
	public String password;
	
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
	@Override
	public String toString() {
		return "Connection [userid=" + userid + ", password=" + password + "]";
	}
}
