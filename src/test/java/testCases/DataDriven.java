package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {
	
	WebDriver driver;
	
	@DataProvider(name="mydata")
	public Object[] [] mylogin()
	{
		Object [] [] data = new Object[2] [2];
		data[0][0]="student";
		data[0][1]="Password123";
		data[1][0]="student1";
		data[1][1]="Password1234";
				
		return data;
	}
	@Test
	void browseropen()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
	}
	
	@Test(dataProvider="mydata")
	public void datadriventesting(String username, String password)
	{
			driver.findElement(By.id("username")).sendKeys(username);    
			driver.findElement(By.id("password")).sendKeys(password);    
			driver.findElement(By.id("submit")).click();
			driver.findElement(By.xpath("//a[text()=\"Log out\"]")).click();
	}
}
