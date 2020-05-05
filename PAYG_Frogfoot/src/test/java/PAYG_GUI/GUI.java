package PAYG_GUI;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GUI 
{
	WebDriver driver = null;
	String url = "http://dfaapicrlab01.dfa.local:8080/payg-1.0/";
	
	@BeforeTest
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();		
	}
	
	@Test(priority=1) /*The data of records for the month September-2019*/
	public void sepData() throws InterruptedException 
	{
		driver.findElement(By.id("clientId")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("Frogfoot").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("GPON").perform();
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr/td/span[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[9]")).click();
		driver.findElement(By.id("emailList")).sendKeys("Bhaskar.GVE@dfafrica.co.za");;
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(30000);
		String printMsg=driver.findElement(By.xpath("//*[@id=\"resultMessage\"]")).getText();
		assertEquals(printMsg, "Your request has been submitted successfully with parameters: startDate: 25-08-2019, endDate: 24-09-2019, emailList: Bhaskar.GVE@dfafrica.co.za");
		System.out.println(printMsg);
		driver.navigate().refresh();
		
	}
	
	@Test(priority=2) /*The data of records for the month October-2019*/
	public void octData() throws InterruptedException 
	{
		driver.findElement(By.id("clientId")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("Frogfoot").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("GPON").perform();
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr/td/span[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[10]")).click();
		driver.findElement(By.id("emailList")).sendKeys("Bhaskar.GVE@dfafrica.co.za");;
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(30000);
		String printMsg=driver.findElement(By.xpath("//*[@id=\"resultMessage\"]")).getText();
		assertEquals(printMsg, "Your request has been submitted successfully with parameters: startDate: 25-09-2019, endDate: 24-10-2019, emailList: Bhaskar.GVE@dfafrica.co.za");
		System.out.println(printMsg);
		driver.navigate().refresh();
	}
	
	@Test(priority=3) /*The data of records for the month November-2019*/
	public void novData() throws InterruptedException 
	{
		driver.findElement(By.id("clientId")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("Frogfoot").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("GPON").perform();
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr/td/span[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[11]")).click();
		driver.findElement(By.id("emailList")).sendKeys("Bhaskar.GVE@dfafrica.co.za");;
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(30000);
		String printMsg=driver.findElement(By.xpath("//*[@id=\"resultMessage\"]")).getText();
		assertEquals(printMsg, "Your request has been submitted successfully with parameters: startDate: 25-10-2019, endDate: 24-11-2019, emailList: Bhaskar.GVE@dfafrica.co.za");
		System.out.println(printMsg);
		driver.navigate().refresh();
	}
	
	@Test(priority=4) /*Valid emailList and Invalid Month&Year - Jan2020*/
	public void invalidMonthYearWithValidemailList() throws InterruptedException 
	{
		driver.findElement(By.id("clientId")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("Frogfoot").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("GPON").perform();
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[1]")).click();
		driver.findElement(By.id("emailList")).sendKeys("Bhaskar.GVE@dfafrica.co.za");
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		String printMsg=driver.findElement(By.id("resultMessage")).getText();
		assertEquals(printMsg, "Selected month does not have data available");
		System.out.println(printMsg);
		driver.navigate().refresh();
	}
	
	@Test(priority=5) /*Invalid emailList*/
	public void invalidemailList() throws InterruptedException 
	{
		driver.findElement(By.id("clientId")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("Frogfoot").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("GPON").perform();
		act.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr/td/span[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[11]")).click();
		driver.findElement(By.id("emailList")).sendKeys("basubsc@gmail.com");;
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		String printMsg=driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[6]/div/div")).getText();
		assertEquals(printMsg, "Invalid E-mail address(es) (DFA only email address)!");
		System.out.println(printMsg);
		driver.navigate().refresh();
	}
	
	@Test(priority=6) /*Two Valid emailLists*/
		public void twoValidemailLists() throws InterruptedException 
		{
			driver.findElement(By.id("clientId")).click();
			Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys("Frogfoot").perform();
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys("GPON").perform();
			act.sendKeys(Keys.TAB).perform();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr/td/span[1]")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[11]")).click();
			driver.findElement(By.id("emailList")).sendKeys("Bhaskar.GVE@dfafrica.co.za,siyabonga.mpangase@dfafrica.co.za");;
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys(Keys.ENTER).perform();
			Thread.sleep(30000);
			String printMsg=driver.findElement(By.id("resultMessage")).getText();			
			System.out.println(printMsg);
			assertEquals(printMsg, "Your request has been submitted successfully with parameters: startDate: 25-10-2019, endDate: 24-11-2019, emailList: Bhaskar.GVE@dfafrica.co.za,siyabonga.mpangase@dfafrica.co.za");
			driver.navigate().refresh();
		}
		
		@Test(priority=7) /*Enter one Valid emailList and One Invalid emailList*/
		public void oneValidemailListoneInvalidemailList() throws InterruptedException 
		{
			driver.findElement(By.id("clientId")).click();
			Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys("Frogfoot").perform();
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys("GPON").perform();
			act.sendKeys(Keys.TAB).perform();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr/td/span[1]")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[11]")).click();
			driver.findElement(By.id("emailList")).sendKeys("Bhaskar.GVE@dfafrica.co.za,basubsc@gmail.com");;
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys(Keys.ENTER).perform();
			String printMsg=driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[6]/div/div")).getText();			
			System.out.println(printMsg);
			assertEquals(printMsg, "Invalid E-mail address(es) (DFA only email address)!");
			driver.navigate().refresh();
		}
		
		@Test(priority=8) /*Enter space between emailLists*/
		public void spaceBetweenemailLists() throws InterruptedException 
		{
			driver.findElement(By.id("clientId")).click();
			Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys("Frogfoot").perform();
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys("GPON").perform();
			act.sendKeys(Keys.TAB).perform();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr/td/span[1]")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[11]")).click();
			driver.findElement(By.id("emailList")).sendKeys("Bhaskar.GVE@dfafrica.co.za, siyabonga.mpangase@dfafrica.co.za");;
			act.sendKeys(Keys.TAB).perform();
			act.sendKeys(Keys.ENTER).perform();
			String printMsg=driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[6]/div/div")).getText();			
			System.out.println(printMsg);
			assertEquals(printMsg, "Invalid E-mail address(es) (DFA only email address)!");
			driver.navigate().refresh();
		}
		
		@AfterTest
		public void closeUp()
		{
			driver.close();
		}
		



}
