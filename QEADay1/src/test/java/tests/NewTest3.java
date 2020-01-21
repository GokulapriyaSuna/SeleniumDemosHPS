package tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest3 {
	@Test
	public void testKeys() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		/*
		 * WebElement fromtag=driver.findElement(By.id("FromTag")); Actions act1=new
		 * Actions(driver); act1.keyDown(fromtag,
		 * Keys.SHIFT).sendKeys("h").keyUp(Keys.SHIFT).pause(3000).sendKeys("yd").
		 * pause(4000).sendKeys(Keys.ENTER).perform();
		 */
		
		WebElement toTag=driver.findElement(By.id("ToTag"));
		toTag.sendKeys("hyd");
		//Thread.sleep(6000);
		//WebDriverWait wait=new WebDriverWait(driver,10);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("ui-id-2"), 
				By.className("list")));
		
		WebElement ul=driver.findElement(By.id("ui-id-2"));
		List<WebElement> list= ul.findElements(By.tagName("li"));
		Assert.assertEquals(list.size(),3);
		
		for(WebElement e:list)
		{
			if(e.getText().contains("HYD"))
			{
				e.click();
			}
		}
		
		//Actions act2=new Actions(driver);
		//act2.sendKeys(toTag,"ban").pause(5000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
	}

}
