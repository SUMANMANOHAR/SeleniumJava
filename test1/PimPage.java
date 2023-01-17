package test1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage {

	WebDriver driver;

	By pimClick = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a");
	By add = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	By firstName = By.xpath("//*[@name=\"firstName\"]");
	By middleName = By.xpath("//*[@name=\"middleName\"]");
	By lastName = By.xpath("//*[@name=\"lastName\"]");
	By empid1 = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
	By photo = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button/i");
	By create = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span");
	By username_data1 = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input");
	By password_data1 = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input");
	By confirmPassword = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input");
	By save = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");

	public PimPage(WebDriver driver)

	{

		this.driver = driver;

	}

	public void clickPim() throws Exception

	{
		Properties ppt = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\project1\\datadriven\\test2.properties");
		ppt.load(fis);

		String firstname = ppt.getProperty("firstname");
		String middlename = ppt.getProperty("middlename");
		String lastname = ppt.getProperty("lastname");
		String empid = ppt.getProperty("empid");
		String username_data = ppt.getProperty("username_data");
		String password_data = ppt.getProperty("password_data");
		String confirmpassword = ppt.getProperty("confirmpassword");

		driver.findElement(pimClick).click();
		driver.findElement(add).click();

		driver.findElement(firstName).sendKeys(firstname);

		driver.findElement(middleName).sendKeys(middlename);

		driver.findElement(lastName).sendKeys(lastname);

		driver.findElement(empid1).sendKeys(empid);

		driver.findElement(photo).click();

		StringSelection photopath = new StringSelection(
				"E:\\SHARMA'S\\my images\\NOTE 7 PRO\\Camera\\New folder (2)\\suman.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(photopath, null);

		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e1) {
			e1.printStackTrace();

		}
		driver.findElement(create).click();

		driver.findElement(username_data1).sendKeys(username_data);

		driver.findElement(password_data1).sendKeys(password_data);

		driver.findElement(confirmPassword).sendKeys(confirmpassword);

		driver.findElement(save).click();

	}

}
