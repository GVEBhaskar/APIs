package com.ICT_Permit_Log_WebApp;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RoleAsAdmin 
{
	String url = "https://apigwlab.dfafrica.co.za:8443/ictpermitlog/index.jsp";
	WebDriver driver = null;
	@BeforeTest
	public void startUP()
	{
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test(priority=0)/*Login*/
	public void adminLogin()
	{
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div/div[1]/div/div")).click();
		driver.findElement(By.id("email")).sendKeys("raj@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submitReq")).click();
	}
	@Test(priority=1)
	public void authContributors() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div[1]/div/div")).click();
		Thread.sleep(3000);
		String contributorValid=driver.findElement(By.id("resultMessage")).getText();
		Thread.sleep(3000);
		assertTrue(contributorValid.contains("You are not Authorized to access this resource"));
	}
	@Test(priority=2)
	public void companiesViewFilterAddUpdateDelete() throws InterruptedException
	{
		//View
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[3]/a")).click();
		String viewValid=driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[3]/div/div/div[1]/h3")).getText();
		Assert.assertEquals(viewValid, "Company List");
		Thread.sleep(2000);
		
		//Filter
		driver.findElement(By.id("nameFilter")).sendKeys("Ram");
		Thread.sleep(2000);
		String filterValid=driver.findElement(By.className("text-left")).getText();Thread.sleep(5000);
		assertTrue(filterValid.contains("Ram"));
		
		//Add
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div/a")).click();
		driver.findElement(By.id("reg_name")).sendKeys("Trisha");
		driver.findElement(By.id("reg_number")).sendKeys("Reg9923577");
		driver.findElement(By.id("trade_name")).sendKeys("Film Industry pyt ltd");
		driver.findElement(By.id("contact_num")).sendKeys("09799375593");
		driver.findElement(By.id("web_url")).sendKeys("myangelbeb.com");
		driver.findElement(By.id("addr_1")).sendKeys("Chennai");
		driver.findElement(By.id("suburb")).sendKeys("Madras");
		driver.findElement(By.id("city")).sendKeys("TamilNadu");
		WebElement dD=driver.findElement(By.id("province"));
		Select sel = new Select(dD);
		sel.selectByValue("Gauteng");
		driver.findElement(By.id("post_code")).sendKeys("0192");
		driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		String addValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(addValid.contains("Your request was successful"));Thread.sleep(3000);
		
		//Update
		driver.findElement(By.xpath("//*[@id=\"company_list\"]/tr[10]/td[6]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("trade_name")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("trade_name")).sendKeys("Picture Company");
		Thread.sleep(2000);
		driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		String updateValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(updateValid.contains("Your request was successful"));Thread.sleep(3000);
		
		//Delete
		driver.findElement(By.xpath("//*[@id=\"company_list\"]/tr[9]/td[6]/button")).click();
		driver.switchTo().alert().accept();Thread.sleep(3000);
		String delValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(delValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@Test(priority=3)
	public void fieldWorkersViewFilterAddUpdateDelete() throws InterruptedException
	{
		//View
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		String viewValid=driver.findElement(By.className("panel-title")).getText();
		Assert.assertEquals(viewValid, "Field Workers List");
		Thread.sleep(2000);
		
		//Filter
		driver.findElement(By.className("form-control")).sendKeys("Kak");
		Thread.sleep(2000);
		String filterValid=driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tr[4]/td[1]")).getText();
		Thread.sleep(5000);
		assertTrue(filterValid.contains("Kak"));Thread.sleep(2000);
		
		//Add
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div/a")).click();
		driver.findElement(By.id("firstname")).sendKeys("Kishor babu");
		driver.findElement(By.id("lastname")).sendKeys("Rati");
		driver.findElement(By.id("idnumber")).sendKeys("09936621");
		driver.findElement(By.id("role")).sendKeys("Telephone Operator");
		WebElement dD=driver.findElement(By.id("company"));
		Select sel = new Select(dD);
		sel.selectByValue("71");
		driver.findElement(By.id("submitReq")).click();
		Thread.sleep(3000);
		String addValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(addValid.contains("Your request was successful"));Thread.sleep(3000);
		
		//Update
		driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tr[2]/td[6]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("firstname")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("firstname")).sendKeys("Kishore R");
		Thread.sleep(2000);
		driver.findElement(By.id("lastname")).sendKeys("Filming");
		Thread.sleep(2000);
		driver.findElement(By.id("role")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("role")).sendKeys("Producer");
		Thread.sleep(2000);
		WebElement dD1=driver.findElement(By.id("company"));
		Select sel1 = new Select(dD1);
		sel1.selectByValue("74");
		Thread.sleep(3000);
		driver.findElement(By.id("submitReq")).click();
		Thread.sleep(3000);
		String updateValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(updateValid.contains("Your request was successful"));Thread.sleep(3000);
		
		//Delete
		driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tr[2]/td[6]/button")).click();
		driver.switchTo().alert().accept();
		String delValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(delValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@AfterTest()
	public void tearDown()
	{
		driver.close();
	}
}
