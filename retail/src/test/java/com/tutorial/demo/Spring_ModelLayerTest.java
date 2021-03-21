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
}
