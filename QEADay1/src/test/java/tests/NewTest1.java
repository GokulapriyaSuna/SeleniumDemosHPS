package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {
	
	@Test(groups = "dry")
	public void testCardLink()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://hdfcbank.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("popupBoxClose")).click();
	
		Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.cssSelector("a[title='Pay']"))).pause(3000).perform();
		driver.findElement(By.xpath("//a[@href='/personal/pay/cards/credit-cards']")).click();
		String title=driver.getTitle();
		Assert.assertTrue(title.startsWith("Credit Card"));
	
		
	}

}
