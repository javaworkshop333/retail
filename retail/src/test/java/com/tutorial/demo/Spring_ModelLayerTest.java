package com.tutorial.demo;
import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.spring.beans.ProfileBean;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Spring_ModelLayerTest {
	
	public ProfileBean profile; // scanned in test spring config class

	@Autowired
	public void setProfile(ProfileBean profile) {
		this.profile = profile;
	}

	@Test
	public void Test1SpringRegisterTest() throws Exception {
		boolean res = profile.register("tester", "test123!", "test", "123");
		assertEquals(true, res);
	}
	@Test
	public void Test2SpringUpdateTest() throws Exception {
		boolean res = profile.update("tester", "test123@");
		assertEquals(true,res);
	}
	@Test
	public void Test3SpringDeleteTest() throws Exception {
		boolean res = profile.delete("tester");
		assertEquals(true,res);
	}
	@Test
	public void Test3SpringDeleteTestUidNotExist() throws Exception {
		boolean res = profile.delete("abc");
		assertEquals(false,res);
	}
	/* For all Usecase below , write 1 testcase each
	 	userid empty = return false
	 	password empty return false
	 	both are empty return false
	 	userid is invalid = return false
	 	password is invalid return false
	 	if both are correct return true
	 */
	@Test
	public void Test41checkUserEmptyUserid() throws Exception {
		boolean res = profile.loginCheck("", "asd");
		assertEquals(false,res);
	}
	@Test
	public void Test42checkUserEmptyPassword() throws Exception {
		boolean res = profile.loginCheck("asd", "");
		assertEquals(false,res);
	}	
	@Test
	public void Test43checkUserEmptyPasswordAndEmptyUserid() throws Exception {
		boolean res = profile.loginCheck("", "");
		assertEquals(false,res);
	}	

	@Test
	public void Test44checkUserinvalidUserid() throws Exception {
		boolean res = profile.loginCheck("jane", "asd");
		assertEquals(false,res);
	}

	@Test
	public void Test45checkUserValidUserid() throws Exception {
		boolean res = profile.loginCheck("jane", "jane123");
		assertEquals(true,res);
	}
}
