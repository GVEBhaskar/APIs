package com.PortalRegistration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

public class APIAccess_DevPortal 
{
	@Test
	public void login() throws InterruptedException
	{
		String url = "https://apidplab.dfafrica.co.za/admin/app/home";
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("form-username")).sendKeys("Bhaskar.GVE");
		driver.findElement(By.id("form-password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//*[@id=\"internal-authscheme-form\"]/fieldset/button[1]")).click();
		/*click on publish*/
		driver.findElement(By.xpath("//*[@id=\"phoenix-dashboard\"]/div/div/div[1]/div[2]/div/div[1]/div/div/div/a/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"phoenix-header\"]/div/div/div/div[1]/div/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"s2id_apiexplorer-api\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div")).click();
		driver.findElement(By.xpath("//*[@id=\"s2id_apiexplorer-api-key\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"resource_ductBank\"]/div/div[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"listDuctBank-section0\"]/div/form/section/div/table/tbody/tr[1]/td[2]/div/input")).sendKeys("1=1");
		WebElement dD=driver.findElement(By.xpath("//*[@id=\"listDuctBank-section0\"]/div/form/section/div/table/tbody/tr[10]/td[2]/select"));
		Select sel = new Select(dD);
		sel.selectByValue("false");
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[2]/div[3]/ul/li[1]/ul/li/div/div/div/div/div[2]/div/form/button[1]")).click();
	}
}
