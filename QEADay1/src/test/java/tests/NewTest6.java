package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest6 {
	
	@Test
	public void testJS()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://hdfcbank.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("popupBoxClose")).click();
		
		/*
		 * int x=10; long y=x;//implicit conversion int z=(int) y;//explicit conversion
		 * 
		 */	//driver.findElement(By.xpath("//li[contains(text(),'Deposits')]")).click();
		WebElement prodtype=driver.findElement(By.xpath("//li[contains(text(),'Deposits')]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",new Object[] {prodtype});
		js.executeScript("window.scrollBy(0,1000)");
	}
}
