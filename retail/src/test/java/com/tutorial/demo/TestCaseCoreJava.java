package com.tutorial.demo;

import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.util.Calculator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
public class TestCaseCoreJava {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@AfterClass // AfterClass, Before, After
	public static void end() {
		System.out.println("cleanup");
	}
	@BeforeClass // AfterClass, Before, After
	public static void begin() {
		System.out.println("setup");
	}
	@Before // AfterClass, Before, After
	public  void beginMethod() {
		System.out.println("setup method");
	}
	@After // AfterClass, Before, After
	public  void endMethod() {
		System.out.println("cleanup method");
	}
	
	@Test
	public void testEquals() {
		System.out.println("runnng test add");
		Calculator c=new Calculator();
		int sum=c.add(1, 1);
		// test output equals
		assertEquals("1 + 1 is always 2 " ,2 ,sum);
		//("failure message", expected output, method call to be tested)
	}	
	@Test
	public void TestError(){
		System.out.println("runnng test calculator");
		Calculator c=new Calculator();
		// test exception output
		exception.expect(ArithmeticException.class);
		c.div(1,0);
	}
	@Test
	public void TestNotEquals(){
		System.out.println("runnng test calculator");
		Calculator c=new Calculator();
		int mul=c.mul(5, 5);
		// test output not equals
		assertNotEquals("5 times 5 is never 10", 10 , mul);
	}
}
