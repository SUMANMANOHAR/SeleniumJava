package assignmentmodule1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get ("https://www.amazon.in/");
		    
		    driver.findElement(By.linkText("Electronics")).click();
		    driver.findElement(By.linkText("Customer Service")).click();
		    driver.findElement(By.partialLinkText("Sell under Amazon")).click();
			driver.navigate().back();
			driver.navigate().forward();
		//driver.close();  //it is commented because it will close soon if we run it without commenting

	}

}
