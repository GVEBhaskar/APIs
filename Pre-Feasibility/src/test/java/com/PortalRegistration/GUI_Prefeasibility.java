package com.PortalRegistration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GUI_Prefeasibility 
{
	String url = "http://dfaapicrlab01.dfa.local:8080/prefeasibility-web/";
	WebDriver driver = null;
	@BeforeTest /*Launching browser*/
	public void startUP()
	{
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test (priority=0) /*Selection of Product*/
	public void selectProduct() throws InterruptedException
	{
		WebElement mag=driver.findElement(By.id("productType"));
		Select sel = new Select(mag);
		sel.selectByVisibleText("Magellan");
		//Thread.sleep(3000);
	}
	@Test (priority=1) /*Passing Coordinates*/
	public void passCoordinates() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("-25.859770").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("28.214739").perform();
	}
	@Test (priority=2)
	public void selectBandwidth()
	{
		WebElement prodBand=driver.findElement(By.id("productBandwidth"));
		Select sel = new Select(prodBand);
		sel.selectByValue("5");
	}
	@Test (priority=3)
	public void selectTerm() throws InterruptedException
	{
		WebElement contractTerm=driver.findElement(By.id("contractTerm"));
		Select sel = new Select(contractTerm);
		sel.selectByValue("1");
		driver.findElement(By.id("submitReq")).click();
		Thread.sleep(20000);
		System.out.println("Result Message is: "+driver.findElement(By.id("resultMessage")).getText());
		String prntMsg=driver.findElement(By.xpath("//*[@id=\"prefeasibility-results\"]/div/div/div[2]")).getText();
			
		System.out.println("Response is: ");
		System.out.println();
		System.out.println(prntMsg);
		//driver.findElement(By.xpath("//*[@id=\"header-logo\"]/a/img")).click();
	}
	//@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
