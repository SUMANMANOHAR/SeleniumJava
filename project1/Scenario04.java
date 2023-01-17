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

public class Scenario04 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\TestAutomationBatchJuly17\\src\\test\\java\\Scenario03.properties");

		p.load(fis);
		String url_data = p.getProperty("url");
		String username = p.getProperty("username");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url_data);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement forgotPassword = driver
				.findElement(By.xpath(("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")));
		forgotPassword.click();

		WebElement userName = driver.findElement(By.xpath(("//*[@name=\"username\"]")));
		userName.sendKeys(username);

		WebElement reset = driver.findElement(By.xpath(("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]")));
		reset.click();

	}

}
