package testCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IteratorClass {
	
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
	
	Set<String> allwindow = driver.getWindowHandles();
	Iterator<String> itr = allwindow.iterator();
	String parrent = itr.next();
	String child1  = itr.next();
	String child2 =itr.next();
	driver.switchTo().window(child2);
	driver.close();
	driver.switchTo().window(parrent);
	System.out.println(driver.getTitle());
	driver.switchTo().window(child1);
	driver.close();
	}

}
