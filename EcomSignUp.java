package com.mphasis.selenium.SeleniumDemo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EcomSignUp {

 public static void main(String[] args) throws InterruptedException {
 
	 System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\91976\\\\Downloads\\\\chromedriver_win32 (2)\\\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
  
  String URL="http://automationpractice.com/index.php";

  driver.get(URL);
  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
  driver.manage().window().maximize();
  
  //Click on Sign in
  driver.findElement(By.linkText("Sign in")).click();
  
  //Enter email address
  driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("test371@gmail.com");
  
  //Click on "Create an account"
  driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
  
  //Select Title
  driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
  driver.findElement(By.name("customer_firstname")).sendKeys("Tom");
  driver.findElement(By.name("customer_lastname")).sendKeys("jerry");
  driver.findElement(By.id("passwd")).sendKeys("PKR@PKR");
  Thread.sleep(2000);
  
  // Enter your address
  driver.findElement(By.id("firstname")).sendKeys("Tom");
  driver.findElement(By.id("lastname")).sendKeys("jerry");
  driver.findElement(By.id("company")).sendKeys("mphasis");
  driver.findElement(By.id("address1")).sendKeys("Test 81/1,2nd cross");
  driver.findElement(By.id("city")).sendKeys("XYZ");
  Thread.sleep(2000);
  
  // Select State
  WebElement statedropdown=driver.findElement(By.name("id_state"));
  Select oSelect=new Select(statedropdown);
  oSelect.selectByValue("4");

  driver.findElement(By.name("postcode")).sendKeys("51838");
  
  // Select Country
  WebElement countrydropDown=driver.findElement(By.name("id_country"));
  Select oSelectC=new Select(countrydropDown);
  oSelectC.selectByVisibleText("United States");
  
  //Enter Mobile Number
  driver.findElement(By.id("phone_mobile")).sendKeys("234567890");
  driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
  driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
  driver.findElement(By.name("submitAccount")).click();
  String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

  // Validate that user has created
  if(userText.contains("jerry")) {
   System.out.println("User Verified,Test case Passed");
  }
  else {
   System.out.println("User Verification Failed,Test case Failed");
  }
 }
}

