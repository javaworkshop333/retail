package com.tutorial.demo;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
//add multiple test cases into 1 test suite
@SuiteClasses({TestCaseCoreJava.class,JPA_DataAccessLayerTest.class,Spring_ModelLayerTest.class,Struts_ControllerLayerTest.class})
class RetailApplicationTests {
 
}
