package com.PortalRegistration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class rough 
{
	@Test
	public void roughy()
	{
		
		String url = "https://www.justdial.com/Bangalore/Bakeries";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
        WebDriver driver = null;
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> bakeries = driver.findElements(By.className("store-name"));

        System.out.println(bakeries.size());

        for (WebElement webElement : bakeries) {
            String name = webElement.getText();
            System.out.println(name);
        }
	}
	
}
