package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindow2 {
	
	WebDriver driver;
	
	@Test
	void windowhandle() throws InterruptedException
	{
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	driver.findElement(By.id("newWindowsBtn")).click();
	
	//method one
	
//	Set <String> allwindow = driver.getWindowHandles();
//	List <String> list = new ArrayList(allwindow);
//	String parrent = list.get(0);
//	String child1 = list.get(1);
//	String child2 = list.get(2);
//	driver.switchTo().window(child2);
//	System.out.println(driver.getTitle());
//	driver.close();
//	driver.switchTo().window(child1);
//	System.out.println(driver.getTitle());
	
	//method two
	
	Set<String> allwindow = driver.getWindowHandles();
	List<String> list=new ArrayList(allwindow);
	
	for(String a :list)
	{
		driver.switchTo().window(a);
		String b = driver.getTitle();
		System.out.println(b);
		
		if(b.equalsIgnoreCase("XPath Practice - H Y R Tutorials"))
		{
			Thread.sleep(3000);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@maxlength=\"10\"]")).sendKeys("abc");
			//driver.close();
		}
		else if(b.equals("Window Handles Practice - H Y R Tutorials"))
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("xyz");
		}
		else if(b.equals("Basic Controls - H Y R Tutorials"))
		{
			driver.close();
		}
				
	}
		
	
}
}
