package project1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario03 {

	private static final CharSequence militaryService = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\TestAutomationBatchJuly17\\src\\test\\java\\Scenario03.properties");

		p.load(fis);
		String url_data = p.getProperty("url");
		String username = p.getProperty("username");
		String pw_data = p.getProperty("password");
		String loginPath = p.getProperty("login");
		String nickname = p.getProperty("nickname");
		String otherId = p.getProperty("otherId");
		String militaryservice = p.getProperty("militaryservice");
		String drivinglicence = p.getProperty("drivinglicence");
		String ssnno = p.getProperty("ssnno");
		String sinno = p.getProperty("sinno");
		String comment = p.getProperty("comment");

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

		WebElement login = driver.findElement(By.xpath(("//*[@class=\"oxd-form-actions orangehrm-login-action\"]")));
		login.click();

		WebElement myInfo = driver
				.findElement(By.xpath(("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span")));
		myInfo.click();

		WebElement nickname1 = driver.findElement(By.xpath(
				("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div[2]/input\r\n"
						+ "		")));
		nickname1.sendKeys(nickname);

		WebElement otherId1 = driver.findElement(By.xpath(
				("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input")));
		otherId1.sendKeys(otherId);

		WebElement drivingLicence = driver.findElement(By.xpath(
				("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input\r\n"
						+ "		")));
		drivingLicence.sendKeys(drivinglicence);

		WebElement ssnno1 = driver.findElement(By.xpath(
				("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[1]/div/div[2]/input")));
		ssnno1.sendKeys(ssnno);

		WebElement sinno1 = driver.findElement(By.xpath(
				("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[2]/div/div[2]/input")));
		sinno1.sendKeys(sinno);

		WebElement nationality = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i"));
		nationality.click();
		List<WebElement> list = driver.findElements(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i/div[2]/div"));
		System.out.println("LIST" + list.size());
		for (WebElement wemainmenu : list) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("Indian")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;

			}
		}
		WebElement maritalStatus = driver.findElement(By.xpath(
				("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[2]/i")));
		maritalStatus.click();
		List<WebElement> list1 = driver.findElements(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[2]/i/div[2]/div"));
		System.out.println("LIST" + list1.size());
		for (WebElement wemainmenu : list1) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("Single")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;

			}
		}

		WebElement male = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/label/span\r\n"
						+ ""));
		male.click();

		WebElement military = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[1]/div/div[2]/input"));
		military.sendKeys(militaryservice);

		WebElement save = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/button"));
		save.click();

		WebElement bloodType = driver.findElement(By.xpath(
				"//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div"));
		bloodType.click();
		List<WebElement> bloodType1 = driver.findElements(By.xpath(
				"//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div/div[2]/div"));
		System.out.println("LIST" + bloodType1.size());
		for (WebElement wemainmenu : bloodType1) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("B+")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;

			}

		}

		WebElement save1 = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/button"));
		save1.click();

		WebElement browse = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[1]/div/div/div/div[2]/div/i"));
		browse.click();

		StringSelection browsepath = new StringSelection("E:\\resume1\\newresume");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(browsepath, null);

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

		WebElement comment1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[2]/div/div/div/div[2]/textarea"));
		comment1.sendKeys(comment);

		WebElement save2 = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]"));
		save2.click();

	}
}