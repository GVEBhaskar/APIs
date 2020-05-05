package com.ICT_Permit_Log_WebApp;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
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

public class RoleAsSuperAdmin 
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
		driver.findElement(By.id("email")).sendKeys("Bhaskar.GVE@dfafrica.co.za");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submitReq")).click();
	}
	@Test(priority=1)/*View Contributors*/
	public void viewContributors() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[2]/a")).click();
		String actualTExt=driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[3]/div/div/div[1]/h3")).getText();
		Assert.assertEquals(actualTExt, "Contributor List");
	}
	@Test(priority=2)/*Filter Contributors*/
	public void filterContributors() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"nameFilter\"]")).sendKeys("April");
		String actualText = driver.findElement(By.xpath("//*[@id=\"contributor_list\"]/tr[1]/td[1]")).getText();
		assertTrue(actualText.contains("Apr"));
	}
	@Test(priority=3)/*Add Contributor*/
	public void addContributor() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div/a")).click();
		driver.findElement(By.id("firstname")).sendKeys("Modi");
		driver.findElement(By.id("lastname")).sendKeys("Pradhaani");
		WebElement dDAdmin=driver.findElement(By.xpath("//*[@id=\"role\"]"));
		Select sel = new Select(dDAdmin);
		sel.selectByValue("admin");		
		driver.findElement(By.id("email")).sendKeys("govt13182@mail.com");
		driver.findElement(By.id("password")).sendKeys("govt");
		driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		String addValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(addValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@Test(priority=4)/*Update Contributor*/
	public void updateContributor() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"contributor_pagination\"]/div/div/ul/li[8]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"contributor_list\"]/tr[2]/td[5]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("firstname")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("firstname")).sendKeys("Modiji PM");
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("govt1323");
		Thread.sleep(3000);
		driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		String updateValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(updateValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@Test(priority=5)/*Delete Contributor*/
	public void deleteContributors() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[2]/a")).click();Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"contributor_pagination\"]/div/div/ul/li[8]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"contributor_list\"]/tr[2]/td[5]/button")).click();
		driver.switchTo().alert().accept();Thread.sleep(3000);
		String delValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(delValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@Test(priority=6)/*View Company*/
	public void viewCompany()
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[3]/a")).click();
		String actualTExt=driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[3]/div/div/div[1]/h3")).getText();
		Assert.assertEquals(actualTExt, "Company List");
	}
	@Test(priority=7)/*Filter Company*/
	public void filterCompany() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nameFilter")).sendKeys("Ram");Thread.sleep(2000);
		String actualText=driver.findElement(By.xpath("//*[@id=\"company_list\"]/tr[3]/td[1]")).getText();
		assertTrue(actualText.contains("Ram"));
	}
	@Test(priority=8)/*Add Company*/
	public void addCompany() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[3]/a")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div/a")).click();
		driver.findElement(By.id("reg_name")).sendKeys("Srinivasa Medicals");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();act.sendKeys("Reg0093w044").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("Medicals Co.").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("900076146").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("www.srinivasamedicals.com").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("Siripuram").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("Narsipatnam").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("26th ward").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("Town City").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("Joburg").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("Gauteng").perform();
		act.sendKeys(Keys.TAB).perform();act.sendKeys("1234").perform();
		//act.sendKeys(Keys.TAB).perform();act.sendKeys(Keys.ENTER).perform();
		//java.lang.Runtime.getRuntime().exec("./AutoIT/FiledOWNLOAD.exe");
		driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		String addValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(addValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@Test(priority=9)/*Update Company*/
	public void updateCompany() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"company_pagination\"]/div/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"company_list\"]/tr[9]/td[6]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("trade_name")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("trade_name")).sendKeys("Medicals Srinivasa");
		Thread.sleep(3000);
		driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		String updateValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(updateValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@Test(priority=10)/*Delete Company*/
	public void delCompany() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"company_pagination\"]/div/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"company_list\"]/tr[9]/td[6]/button")).click();
		driver.switchTo().alert().accept();Thread.sleep(3000);
		String delValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(delValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@Test(priority=11)/*View Field Workers*/
	public void viewFieldWorkers()
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		String actualText=driver.findElement(By.className("panel-title")).getText();
		Assert.assertEquals(actualText, "Field Workers List");
	}
	@Test(priority=12)/*Filter Field Workers*/
	public void filterFieldWorkers() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nameFilter")).sendKeys("Ram");Thread.sleep(2000);
		String actualText=driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tr[2]/td[1]")).getText();
		assertTrue(actualText.contains("Ram"));
	}
	@Test(priority=13)/*Add Field Worker*/
	public void addFieldWorker() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div/a")).click();
		driver.findElement(By.id("firstname")).sendKeys("Rama Krishna");
		driver.findElement(By.id("lastname")).sendKeys("Atchuta");
		driver.findElement(By.id("idnumber")).sendKeys("0098339");
		driver.findElement(By.id("role")).sendKeys("Navy");		
		WebElement dDCompany=driver.findElement(By.id("company"));
		Select sel = new Select(dDCompany);
		sel.selectByValue("58");
		driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		String addValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(addValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@Test(priority=14)/*Update Field Worker*/
	public void updateFieldWorker() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"employee_pagination\"]/div/div/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tr[3]/td[6]/a")).click();Thread.sleep(2000);
		driver.findElement(By.id("firstname")).clear();Thread.sleep(2000);
		driver.findElement(By.id("firstname")).sendKeys("RamKrishna N");Thread.sleep(2000);
		driver.findElement(By.id("lastname")).clear();Thread.sleep(2000);
		driver.findElement(By.id("lastname")).sendKeys("NA");Thread.sleep(2000);
		driver.findElement(By.id("role")).clear();Thread.sleep(2000);
		driver.findElement(By.id("role")).sendKeys("Heli-Mech");Thread.sleep(2000);
		WebElement dDCompany=driver.findElement(By.id("company"));
		Select sel = new Select(dDCompany);
		sel.selectByValue("74");
		driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		String updateValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(updateValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@Test(priority=15)/*Delete Field Worker*/
	public void deleteFieldWorker() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"employee_pagination\"]/div/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tr[3]/td[6]/button")).click();
		driver.switchTo().alert().accept();Thread.sleep(3000);
		String addValid=driver.findElement(By.id("resultMessage")).getText();
		assertTrue(addValid.contains("Your request was successful"));Thread.sleep(3000);
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
