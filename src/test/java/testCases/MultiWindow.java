package testCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindow {
	WebDriver driver;
	@Test
	void window() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		Thread.sleep(3000);
		String parent= driver.getWindowHandle();
		System.out.println("parrent Window:-"+parent);
		driver.findElement(By.id("newWindowsBtn")).click();
		Set<String>handles=driver.getWindowHandles();
		Thread.sleep(3000);
		for(String handle :handles)
		{
		System.out.println(handle);
		
		if(!handle.equals(parent))
		{
			driver.switchTo().window(handle);
			driver.findElement(By.xpath("//input[@maxlength=\"10\"]")).sendKeys("abc");
			Thread.sleep(3000);
			
			driver.switchTo().window(handle);
			driver.findElement(By.id("firstName")).sendKeys("efg");
			driver.close();
		} 
		}
		Thread.sleep(3000);
		driver.switchTo().window(parent);
		driver.findElement(By.id("name")).sendKeys("xyz");
		Thread.sleep(3000);
		driver.quit();
}
}



