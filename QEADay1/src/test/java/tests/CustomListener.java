package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener{
	public static Logger LOGGER=LogManager.getLogger(CustomListener.class);
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("in test start");
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		LOGGER.info("in "+result.getTestClass()+"\t"+result.getMethod().getMethodName()+" success");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("in test failure");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("in test skip");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("in test success percentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("in test failed with timeout");
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("on start");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("on finish");
	}

}
