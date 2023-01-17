package project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\TestAutomationBatchJuly17\\src\\test\\java\\test.properties");

		p.load(fis);
		String url_data = p.getProperty("url");
		String username = p.getProperty("username");
		String pw_data = p.getProperty("password");
		String loginPath = p.getProperty("login");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url_data);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println("userName " + userName);
		userName.sendKeys(username);

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(pw_data);

		WebElement login = driver.findElement(By.xpath(("//button[@type='submit']")));
		login.click();

		WebElement dropdown = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
		dropdown.click();

		WebElement logout = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
		logout.click();

		driver.close();

	}

}
