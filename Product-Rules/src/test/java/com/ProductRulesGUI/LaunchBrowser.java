package com.ProductRulesGUI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaunchBrowser 
{
	WebDriver driver = null;
	String url = "http://dfaapicrlab01.dfa.local:8080/productcatalog/";
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void launchURL() throws InterruptedException
	{
		/*Selecting the specific product i.e., Magellan*/
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"products-table\"]/tbody/tr[1]/td[2]")).click();
		/*Printing the values of specific product i.e., Magellan*/
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("myModalLabel")).getText());
		Thread.sleep(3000);
		String part1="/html/body/div[1]/div[4]/div/div/div[2]/form/div[";
		String part2="]/div/div/span";
		String part3="/html/body/div[1]/div[4]/div/div/div[2]/form/div[";
		String part4="]/div/input";
		for(int i=1; i<=5; i++)
		{
			System.out.print(driver.findElement(By.xpath(part1+i+part2)).getText());
			System.out.println(driver.findElement(By.xpath(part3+i+part4)).getAttribute("value"));
		}
		System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[2]/form/div[6]/div/div/span")).getText());
		WebElement speed=driver.findElement(By.id("modal-speed"));
		Select sel = new Select(speed);
		sel.selectByValue("10");
		sel.getFirstSelectedOption().getAttribute("value");

		/*Esc*/
		//driver.findElement(By.xpath("//*[@id=\"centralModalSm\"]/div/div/div[1]/button")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		/*driver.findElement(By.xpath("//*[@id=\"products-table\"]/tbody/tr[1]/td[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"centralModalSm\"]/div/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"products-table_paginate\"]/span/a[6]")).click();
		driver.findElement(By.xpath("//*[@id=\"products-table\"]/tbody/tr[2]/td[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"modal-product\"]")).sendKeys("usab");
		driver.findElement(By.id("modal-distance")).sendKeys("9");
		driver.findElement(By.id("modal-rate")).sendKeys("00");
		WebElement speed = driver.findElement(By.id("modal-speed"));
		Select sel = new Select(speed);
		sel.selectByValue("65");
		
		WebElement term = driver.findElement(By.id("modal-term"));
		Select sel1 = new Select(term);
		sel1.selectByValue("2");
		
		driver.findElement(By.id("updateBtn")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert element = wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();*/
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
