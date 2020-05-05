package com.ICT_Permit_Log_WebApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadingData_Companies 
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
	@Test(priority=1) //Uploading the data
	public void uploadingCompanyList() throws IOException, InterruptedException
	{
		FileInputStream file = new FileInputStream("./testData/Permit Holders Company Details.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Updated");
		int rowCount=sheet.getLastRowNum();
		driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div[2]/div/div")).click();
		for(int i=2; i<=rowCount; i++)
		{
			Row r=sheet.getRow(i);
			
			driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div/a")).click();
			driver.findElement(By.id("reg_name")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.id("reg_number")).sendKeys(r.getCell(1).getStringCellValue());
			driver.findElement(By.id("trade_name")).sendKeys(r.getCell(2).getStringCellValue());
			driver.findElement(By.id("contact_num")).sendKeys(r.getCell(3).getStringCellValue());
			driver.findElement(By.id("web_url")).sendKeys(r.getCell(4).getStringCellValue());
			driver.findElement(By.id("addr_1")).sendKeys(r.getCell(5).getStringCellValue());
			driver.findElement(By.id("addr_2")).sendKeys(r.getCell(6).getStringCellValue());
			driver.findElement(By.id("addr_3")).sendKeys(r.getCell(7).getStringCellValue());
			driver.findElement(By.id("suburb")).sendKeys(r.getCell(8).getStringCellValue());
			driver.findElement(By.id("city")).sendKeys(r.getCell(9).getStringCellValue());
			driver.findElement(By.id("province")).sendKeys(r.getCell(10).getStringCellValue());
			//Type Casting
			double d=r.getCell(11).getNumericCellValue();
			long x=(long)d;
			String postCode=Long.toString(x);
			driver.findElement(By.id("post_code")).sendKeys(postCode);
			driver.findElement(By.id("submitReq")).click();
			Thread.sleep(3000);
		}
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
