package test1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResetPage {
	WebDriver driver;

	By forgotPassword = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");
	By username_data1 = By.xpath("//*[@name=\"username\"]");
	By resetPassword = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]");

	public ResetPage(WebDriver driver)

	{

		this.driver = driver;

	}

	public void resetPassword() throws Exception

	{
		Properties ppt = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\project1\\datadriven\\test4.properties");
		ppt.load(fis);
		String userName_data1 = ppt.getProperty("username");

		driver.findElement(forgotPassword).click();

		driver.findElement(username_data1).sendKeys(userName_data1);

		driver.findElement(resetPassword).click();

	}
}