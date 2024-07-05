package inteview;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@title=\"Search\"]")).sendKeys("testing");
		driver.findElement(By.xpath("//textarea[@title=\"Search\"]")).sendKeys(Keys.ENTER);
		//search the any text
		
		

	}

}
