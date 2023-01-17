package project2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import test1.DashBoardPage;
import test1.HomePage;
import test1.PimPage;

public class PimPageTest {

	WebDriver driver;

	@Test
	public void f() throws Exception {
		PimPage pimpage = new PimPage(driver);
		pimpage.clickPim();

	}

	@BeforeMethod
	public void launchUrl() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		HomePage homepage = new HomePage(driver);
		homepage.checkUsername();

	}

	@AfterMethod
	public void closeBrowser() {
		// driver.close();

	}
}
