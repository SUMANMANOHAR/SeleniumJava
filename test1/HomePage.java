package test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	By inputUsername = By.xpath("//input[@name='username']");
	By inputPassword = By.xpath("//input[@name='password']");
	By login = By.xpath("//button[@type='submit']");

	public HomePage(WebDriver driver)

	{

		this.driver = driver;

	}

	public void checkUsername() throws Exception

	{
		Properties ppt = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\project1\\datadriven\\test1.properties");
		ppt.load(fis);
		String userName = ppt.getProperty("username");
		String pw_data = ppt.getProperty("password");

		driver.findElement(inputUsername).sendKeys(userName);
		driver.findElement(inputPassword).sendKeys(pw_data);
		driver.findElement(login).click();

	}
}
