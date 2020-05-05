package com.ICT_Permit_Log_WebApp;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UploadingData_FieldWorkers 
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
	@Test(priority=0) //Login
	public void login()
	{
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div/div[1]/div/div")).click();
		driver.findElement(By.id("email")).sendKeys("Bhaskar.GVE@dfafrica.co.za");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submitReq")).click();
	}
	
	//@Test(priority=1)/*Add Field Worker*/
	public void addFieldWorker() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		FileInputStream file = new FileInputStream("./testData/PermitHolder-FWs.xlsx");
		XSSFWorkbook wB = new XSSFWorkbook(file);
		XSSFSheet sheet=wB.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum();
		for (int i=513; i<=rowCount; i++) 
		{
			Row r=sheet.getRow(i);System.out.println(i);
			driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div/a")).click();
			driver.findElement(By.id("firstname")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.id("lastname")).sendKeys(r.getCell(1).getStringCellValue());
			//Type Casting
			/*long x=(long)d;
			String idNum=Long.toString(x);
			driver.findElement(By.id("idnumber")).sendKeys(idNum);*/
			String data=new DataFormatter().formatCellValue(r.getCell(2));
			driver.findElement(By.id("idnumber")).sendKeys(data);
			driver.findElement(By.id("role")).sendKeys(r.getCell(3).getStringCellValue());
			Thread.sleep(1000);
			driver.findElement(By.id("company")).sendKeys(r.getCell(4).getStringCellValue());
			driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		}
	}
	@Test(priority=2)/*Add Field Worker*/
	public void addFieldWorkerExtends() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		FileInputStream file = new FileInputStream("./testData/Book1.xlsx");
		XSSFWorkbook wB = new XSSFWorkbook(file);
		XSSFSheet sheet=wB.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum();
		for (int i=0; i<=rowCount; i++) 
		{
			Row r=sheet.getRow(i);System.out.println(i);
			driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div/a")).click();
			driver.findElement(By.id("firstname")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.id("lastname")).sendKeys(r.getCell(1).getStringCellValue());
			//Type Casting
			/*long x=(long)d;
			String idNum=Long.toString(x);
			driver.findElement(By.id("idnumber")).sendKeys(idNum);*/
			String data=new DataFormatter().formatCellValue(r.getCell(2));
			driver.findElement(By.id("idnumber")).sendKeys(data);
			driver.findElement(By.id("role")).sendKeys(r.getCell(3).getStringCellValue());
			Thread.sleep(1000);
			driver.findElement(By.id("company")).sendKeys(r.getCell(4).getStringCellValue());
			driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
		}
	}
	//@Test(priority=3)/*Delete Field Worker*/
	public void delFieldWorkers() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		String part1="//*[@id=\"employee_list\"]/tr[";
		String part2="]/td[6]/button";
		for (int i=1; i<=10; i++)
		{
			driver.findElement(By.xpath(part1+i+part2)).click();
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		}
		
	}
	//@Test(dataProvider="multiSets")
	public void addFieldWorkers(String Name, String Surname, String IDNumber, String FieldWorker, String Company) throws InterruptedException
	{	
		driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div/a")).click();
		driver.findElement(By.id("firstname")).sendKeys(Name);
		driver.findElement(By.id("lastname")).sendKeys(Surname);
		driver.findElement(By.id("idnumber")).sendKeys(IDNumber);
		driver.findElement(By.id("role")).sendKeys(FieldWorker);		
		driver.findElement(By.id("company")).sendKeys(Company);;
		driver.findElement(By.id("submitReq")).click();Thread.sleep(3000);
	}
	
	//@Test (dataProvider="multiSets") //
	public void emailAddresses(String email) throws InterruptedException
	{
		driver.findElement(By.id("clientId")).sendKeys("Seacom");
		driver.findElement(By.id("productType")).sendKeys("Helios");
		driver.findElement(By.id("dpstartDate")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[2]")).click();
		driver.findElement(By.id("emailList")).sendKeys(email);
		driver.findElement(By.id("submitReq")).click();		
		Thread.sleep(5000);
		driver.findElement(By.id("emailList")).clear();
	}
	//@DataProvider(name="multiSets")
	public String[][] createMultiSetData()
	{
		return new String[][]{
				{ "Bostani","Ntambalikah","MA550550", "Field Worker","Switched on Power (PTY)Ltd"},
				{"Simbarashe","Nyamande","63-2415904Q-80","Field Worker","Universal Power Solution"}
				};
	}
}
