package com.tutorial.demo;

import static org.junit.Assert.assertEquals;
import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.opensymphony.xwork2.ActionProxy;
import com.strut.ProfileAction; 
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Struts_ControllerLayerTest  extends StrutsSpringJUnit4TestCase<ProfileAction> {
	@Test
    public void strut1Reg() throws Exception {
        request.addParameter("userid", "tester");	// pass param to url
        request.addParameter("pwd", "a");
        request.addParameter("fname", "a");
        request.addParameter("lname", "a");
        
        ActionProxy proxy = getActionProxy("/strutreg"); // invoke url
        String result = proxy.execute();
        assertEquals("success", result);        
    }

	@Test
 	public void strut2ChangePassword() throws Exception{
		request.addParameter("userid", "tester");
		request.addParameter("pwd", "tester123");
		ActionProxy proxy=getActionProxy("/changePassword");
		String result=proxy.execute();
		assertEquals("success", result);
	}

	@Test
 	public void strut3DeleteUser() throws Exception{
		request.addParameter("userid", "tester");
		ActionProxy proxy=getActionProxy("/delete");
		String result=proxy.execute();
		assertEquals("success", result);
	}
	

	
}