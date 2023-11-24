package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parallel {
	
	WebDriver driver;
	@Test
	void parallelTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	void parallelTest2() throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.close();
	}
	void parallelTest3() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.close();
	}
	
}
