package assignmentmodule1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\SeleniumFolder\\geckodriver.exe ");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		 driver.get ("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals("Amazon"))
		{
			System.out.println("Titles are matching");
		}
		else 
			System.out.println("ttles are not matching");
	}

}
