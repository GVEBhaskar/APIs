package PAYG_SEACOM_GUI;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GUI_Testing 
{
	String url = "http://dfaapicrlab01.dfa.local:8080/payg-web/";
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
	@Test (priority=0) /*GUI Testing - Launch URL & Look and Feel*/
	public void guiTesting()
	{
		String headText=driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/div/div/div[1]/b")).getText();
		Assert.assertEquals(headText, "Pay As You Grow Report Service");
		String custLinkUsageText=driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[1]/label")).getText();
		Assert.assertEquals(custLinkUsageText, "Customer Link Usage:");
		String prodType_Text=driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[2]/label")).getText();
		Assert.assertEquals(prodType_Text, "Product Type:");
		String reportDate_Text = driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[3]/label")).getText();
		Assert.assertEquals(reportDate_Text, "Report Date:");
		String startDate_Text = driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[4]/label")).getText();
		Assert.assertEquals(startDate_Text, "Start Date:");
		String endDate_Text = driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[5]/label")).getText();
		Assert.assertEquals(endDate_Text, "End Date:");
		String email_Text = driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[6]/label")).getText();
		Assert.assertEquals(email_Text, "Email Address(es) (Comma-delimited, \",\"):");
	}
	@Test (priority=1) /*Usability Testing - Tab Implementation & Error Messages*/
	public void usabilityTesting()
	{
		driver.findElement(By.id("clientId")).sendKeys("Seacom");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();act.sendKeys(Keys.TAB).perform();act.sendKeys(Keys.TAB).perform();
		driver.navigate().refresh();
		driver.findElement(By.id("submitReq")).click();
		String custLinkUsage_Text = driver.findElement(By.className("text-danger")).getText();
		Assert.assertEquals(custLinkUsage_Text, "Invalid Customer Link Usage!");
		String reportDate_Text = driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[3]/div/div")).getText();
		Assert.assertEquals(reportDate_Text, "Invalid Report Month!");
		String email_Text = driver.findElement(By.xpath("//*[@id=\"sandbox-container\"]/div[2]/div/div[6]/div/div")).getText();
		Assert.assertEquals(email_Text, "Invalid E-mail address(es) (DFA only email address)!");
		driver.navigate().refresh();
	}
	@Test (priority=2) /*Validation Testing - DropDown and Text Boxes*/
	public void validationTesting()
	{
		WebElement clientID_dropDown=driver.findElement(By.id("clientId"));
		Select clientID = new Select(clientID_dropDown);
		clientID.selectByValue("seacom");
		WebElement prodType_dropDown=driver.findElement(By.id("productType"));
		Select prodType = new Select(prodType_dropDown);
		prodType.selectByValue("helios");
		driver.findElement(By.id("emailList")).sendKeys("Bhaskar.GVE@dfafrica.co.za");
		String getEmailText=driver.findElement(By.id("emailList")).getAttribute("value");
		System.out.println("Text in the Text Box: "+getEmailText);
		Assert.assertEquals(getEmailText, "Bhaskar.GVE@dfafrica.co.za");
		driver.navigate().refresh();		
	}
	@Test (priority=3) /*Customer Link Usage for the months Jan, Feb & March-2020*/
	public void custLinkUsage() throws InterruptedException
	{
		driver.findElement(By.id("clientId")).sendKeys("Seacom");
		driver.findElement(By.id("productType")).sendKeys("Helios");
		for (int i=1; i<=3; i++)
		{
			driver.findElement(By.xpath("//*[@id=\"dpstartDate\"]")).click();
			String part1="/html/body/div[2]/div[2]/table/tbody/tr/td/span[";
			String part2="]";
			driver.findElement(By.xpath(part1+i+part2)).click();
			driver.findElement(By.id("emailList")).sendKeys("haskar.GVE@dfafrica.co.za");
			driver.findElement(By.id("submitReq")).click();
			Thread.sleep(5000);
			String actualText=driver.findElement(By.id("resultMessage")).getText();
			assertTrue(actualText.contains("Your request has been submitted successfully with parameters:"));
			driver.findElement(By.id("emailList")).clear();
		}
		driver.navigate().refresh();
	}
	@Test (priority=4) /*Product Type drop down selecting */
	public void prodType() throws InterruptedException
	{
		driver.findElement(By.id("clientId")).sendKeys("Seacom");
		WebElement prodType=driver.findElement(By.id("productType"));
		List<WebElement>prodTypes=prodType.findElements(By.tagName("option"));
		//int prodTypes_Count=prodTypes.size();System.out.println(prodTypes_Count);
		for (int i=0; i<prodTypes.size(); i++)
		{
			WebElement element=prodTypes.get(i);
			element.click();
			Thread.sleep(5000);
			driver.findElement(By.id("dpstartDate")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[2]")).click();
			driver.findElement(By.id("emailList")).sendKeys("haskar.GVE@dfafrica.co.za");
			driver.findElement(By.id("submitReq")).click();
			driver.findElement(By.id("emailList")).clear();
		}
		driver.navigate().refresh();		
	}
	@Test (priority=5) //Passing Invalid Report Date
	public void reportDate() throws InterruptedException
	{
		driver.findElement(By.id("clientId")).sendKeys("Seacom");
		driver.findElement(By.id("productType")).sendKeys("Helios");
		driver.findElement(By.id("dpstartDate")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[4]")).click();
		driver.findElement(By.id("emailList")).sendKeys("haskar.GVE@dfafrica.co.za");
		driver.findElement(By.id("submitReq")).click();Thread.sleep(5000);
		String invalidDate_Text=driver.findElement(By.id("resultMessage")).getText();
		Assert.assertEquals(invalidDate_Text, "Selected month does not have data available");
		driver.navigate().refresh();
	}
	@Test (dataProvider="multiSets") //
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
	@DataProvider(name="multiSets")
	public String[][] createMultiSetData()
	{
		return new String[][]{
				{"haskar.GVE@dfafrica.co.za"},
				{"basubsc85@gmail.com"}, 
				{"haskar.GVE@dfafrica.co.za,iyabonga.mpangase@dfafrica.co.za"},
				{"haskar.GVE@dfafrica.co.za,basubsc@gmail.com"},
				{"Bhaskar.GVE@dfafrica.co.za, siyabonga.mpangase@dfarica.co.za"}};
	}
}
