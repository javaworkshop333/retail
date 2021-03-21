package com.tutorial.demo;
import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.hibernate.LoginEntity;
import com.hibernate.springdata.LoginRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPA_DataAccessLayerTest {
	@Autowired
	LoginRepository ur;
	@Test
	public void test1CreateUser() {
		LoginEntity user= new LoginEntity("tester", "tester123", "testFname", "testLname");
		ur.save(user);
		List<LoginEntity>  users= ur.findByUidAndPwd("tester","tester123");
		assertEquals(1, users.size());
	}
	@Test
	public void test2VerifyUser() {
		List<LoginEntity>  log=ur.verify("tester", "tester123");
		assertEquals(1, log.size());
	}
	@Test
	public void test3UpdatePwd() {
		int i=ur.update("tester", "tester234");
		assertEquals(1, i);
	}
	@Test
	public void test4DeleteUser() {
		LoginEntity user= new LoginEntity("tester");
		ur.delete(user);
		List<LoginEntity>  users= ur.findByUidAndPwd("tester","tester123");
		assertEquals(0, users.size());
	}
	
	
}
