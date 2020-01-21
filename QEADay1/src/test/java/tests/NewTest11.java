package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewTest11 {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest tests;
	@BeforeTest
	public void beforeTest()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss-ms");
		String filepath=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
		driver=new ChromeDriver();
		htmlReporter=new ExtentHtmlReporter(filepath);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		htmlReporter.config().setReportName("H&PS");
		htmlReporter.config().setDocumentTitle("My Custom Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		reports.setSystemInfo("Environment","TestEnv");
		reports.setSystemInfo("username","aswani.kumar.avilala");
		
	}
	@AfterTest
	public void afterTest()
	{
		reports.flush();
	}
	@BeforeMethod
	public void beforeMethod(ITestResult result)
	{
		tests=reports.createTest(result.getMethod().getMethodName());
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			//do something
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			//write code for screen capture
			TakesScreenshot screenshot=(TakesScreenshot) driver;
			File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
			String destFile=System.getProperty("user.dir")+"/extent-reports/screenshots/"+
			result.getMethod().getMethodName()+".png";
			try {
				FileUtils.copyFile(srcFile, new File(destFile));
				tests.log(Status.FAIL,"This test is failed");
				tests.addScreenCaptureFromPath(destFile);
				tests.log(Status.FAIL,result.getThrowable().getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
			
		}
	}
	@Test
	public void testExtentReports()
	{
		
		tests.log(Status.PASS, "The test is passed");
	
	}
	@Test
	public void testDemoLogin()
	{
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys("askmail@email.com");
		driver.findElement(By.id("Pass")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
		
	}
}
