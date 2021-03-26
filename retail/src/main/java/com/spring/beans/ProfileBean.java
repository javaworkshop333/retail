package com.spring.beans;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hibernate.LoginEntity;
import com.hibernate.springdata.LoginRepository;

@Service
@Scope("prototype")
public class ProfileBean {
	public LoginEntity ue;

	// Spring Data DI
	@Autowired
	public LoginRepository ur;

	public boolean register(String userid, String pwd, String fname, String lname) {
		LoginEntity ue = new LoginEntity(userid, pwd, fname, lname);
		ur.save(ue);
		return true;
	}

	public boolean update(String userid, String pwd) {
		int i=ur.update(userid, pwd);
		if(i>0)
			return true;
		else
			return false;
	}

	public boolean delete(String userid) {
		int i=ur.delete(userid);
		if(i>0)
			return true;
		else
			return false;
	}
	
	/*
	 	userid empty = return false
	 	password empty return false
	 	both are empty return false
	 	userid is invalid = return false
	 	password is invalid return false
	 	if both are correct return true
	 */
	public boolean loginCheck(String userid,String password) {
		if(userid.equals(""))
			return false;
		if(password.equals(""))
			return false;
		
		List<LoginEntity> le=ur.findByUidAndPwd(userid, password);
		if(le.size() > 0)
			return true;
		else 
			return false;
	}

}
