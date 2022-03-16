package com.mphasis.selenium.SeleniumDemo1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentDemo {

	private WebDriver  driver;
	
	@BeforeMethod
	public void before()
	{
		System.out.println("about");
		 System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\91976\\\\\\\\Downloads\\\\\\\\chromedriver_win32 (2)\\\\\\\\chromedriver.exe");
		 driver = new ChromeDriver();
		url = "https://www.techlistic.com/";
		driver.navigate().to(url);
	}

	//WebDriver driver;
	String url;
	@Test
	public void testOpeningSelenuimHoverLink() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//*[@id='page_list_top']//ul/li[2]//a"));
		Action action = actions.moveToElement(ele)
				.sendKeys(Keys.DOWN)
				.pause(Duration.ofSeconds(1))
				.sendKeys(Keys.DOWN)
				.pause(Duration.ofSeconds(1))
				.click()
				.build();
		action.perform();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	
	}
	@AfterMethod
	public void after()
	{
		driver.close();
	}

}