package com.UxAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WebPortalRegistration 
{

	WebDriver driver = null;
	String url = "https://apidp.dfafrica.co.za/admin/app/home";
	
	@BeforeTest /*Launch URL*/
	public void startUP()
	{
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test (priority=0) /*Customer Registration for get into portal*/
	public void customerRegistration() throws InterruptedException
	{
		driver.findElement(By.id("register")).click();
		Actions act = new Actions(driver);
		
		driver.findElement(By.id("user-email")).sendKeys("xys@gmail.com");
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("xys@gmail.com").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("xys@gmail.com").perform();
		
		WebElement slider=driver.findElement(By.className("slide-text"));
		act.clickAndHold(slider).moveByOffset(520, 0).release().perform();
		slider.click();
		Dimension dim=slider.getSize();
		System.out.println(dim);
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//*[@id=\"registration-form\"]/fieldset[3]/button[1]")).click();
		//String printMsg=driver.findElement(By.xpath("//*[@id=\"registration-component\"]/div[1]/div/div/div")).getText();
		//System.out.println(printMsg);
	}
	
	//@Test (priority=1) /*Login Functionality into the portal*/
	public void navigatingToAPI()
	{
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("form-username")).sendKeys("Basubsc");
		driver.findElement(By.id("form-username")).sendKeys("Basu@2408");
		driver.findElement(By.xpath("//*[@id=\"internal-authscheme-form\"]/fieldset/button[1]")).click();
	}
	
	@AfterTest /*Close URL*/
	public void tearDown()
	{
		driver.close();
	}
	
}
