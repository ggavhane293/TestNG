package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTesting {
	WebDriver driver;
	
	@Test
	public void browserOpen()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	@Test (dataProvider = "provideLogInData")  
	public void logIn (String username, String password) throws Exception 
	{
		
	  driver.findElement(By.id("username")).sendKeys(username);    
	  driver.findElement(By.id("password")).sendKeys(password);    
	  driver.findElement(By.id("submit")).click();
	  driver.findElement(By.xpath("//a[text()=\"Log out\"]")).click();
//
//	  String linkLogout = driver.findElement(By.linkText("Logout?")).getText();    
//	  Assert.assertEquals(linkLogout, "Logout?", "LogIn Unsuccessful - Please Try Again.");
	}

	@DataProvider (name = "provideLogInData")
	public Object [] [] logInData ()
	{
	  Object [] [] data = new Object [3] [2];
	  
	  data [0] [0] = "student";    data [0] [1] = "Password123";    
	  data [1] [0] = "student";      data [1] [1] = "Password123";
	  data [2] [0] = "student";      data [2] [1] = "Password1234";  
	  
	  return data;
	}

}
