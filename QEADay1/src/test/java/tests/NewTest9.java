package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class NewTest9 {
	/*
	 * public static Logger LOGGER=LogManager.getLogger(NewTest9.class);
	 * 
	 * @AfterMethod public void afterMethod(ITestResult result) {
	 * LOGGER.info("in "+result.getMethod().getMethodName()+" passed");
	 * LOGGER.info("status : " +result.getStatus()); }
	 */	@Test
	public void test1()
	{
		System.out.println("in test1");
		//LOGGER.info("in test1 passed");
	
	}

	@Test
	public void test2()
	{
		System.out.println("in test2");
		//LOGGER.info("in test2 passed");
	}

	@Test
	public void test3()
	{
		System.out.println("in test3");
		//LOGGER.info("in test3 passed");
	}

	@Test
	public void test4()
	{
		System.out.println("in test4");
		//LOGGER.info("in test4 passed");
	}

	@Test
	public void test5()
	{
		System.out.println("in test5");
		//LOGGER.info("in test5 passed");
	}
}
