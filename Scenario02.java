package project1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario02 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\TestAutomationBatchJuly17\\src\\test\\java\\run.properties");
		p.load(fis);

		String url_data = p.getProperty("url");
		String username = p.getProperty("username");
		String pw_data = p.getProperty("password");
		String loginPath = p.getProperty("login");
		// String pimXpath = p.getProperty("PIM");
		// String userNamePath = p.getProperty("usernamePath");
		// String passwordPath = p.getProperty("passwordPath");
		String firstname = p.getProperty("firstname");
		String middlename = p.getProperty("middlename");
		String lastname = p.getProperty("lastname");
		String empid = p.getProperty("empid");
		String username_data = p.getProperty("username_data");
		String password_data = p.getProperty("password_data");
		String confirmpassword = p.getProperty("confirmpassword");

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

		WebElement pim = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span"));
		pim.click();

		WebElement add = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		add.click();

		WebElement firstName = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input"));
		firstName.sendKeys(firstname);

		WebElement middleName = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input"));
		middleName.sendKeys(middlename);

		WebElement lastName = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input"));
		lastName.sendKeys(lastname);

		WebElement empid1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
		empid1.sendKeys(empid);

		WebElement photo = driver.findElement(By.xpath("//button[@class='oxd-icon-button employee-image-action']"));
		photo.click();

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

		WebElement create = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span"));
		create.click();

		WebElement username1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
		username1.sendKeys(username_data);

		WebElement password1 = driver.findElement(By.xpath(
				"//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
		password1.sendKeys(password_data);

		WebElement confirmPassword = driver.findElement(By.xpath(
				"//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));
		confirmPassword.sendKeys(confirmpassword);

		WebElement save = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"));
		save.click();

	}

}
