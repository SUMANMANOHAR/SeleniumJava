package project2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import test1.HomePage;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class HomePageTest {
	WebDriver driver;

	@Test
	public void f() throws Exception {
		HomePage homepage = new HomePage(driver);
		homepage.checkUsername();

	}

	@BeforeMethod
	public void launchUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterMethod
	public void closeBrowser() {
		// driver.close();
	}

}
