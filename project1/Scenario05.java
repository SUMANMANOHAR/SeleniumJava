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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\TestAutomationBatchJuly17\\src\\test\\java\\scenario05.properties");
		p.load(fis);

		String url_data = p.getProperty("url");
		String username = p.getProperty("username");
		String pw_data = p.getProperty("password");
		String loginPath = p.getProperty("login");
		String firstname = p.getProperty("firstname");
		String middlename = p.getProperty("middlename");
		String lastname = p.getProperty("lastname");
		String email = p.getProperty("email");
		String phoneno = p.getProperty("phoneno");
		String resume = p.getProperty("resume");
		String notes = p.getProperty("notes");
		String keyword = p.getProperty("keyword");
		String SELECT = p.getProperty("Select1");

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

		WebElement recruitment = driver
				.findElement(By.xpath(("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")));
		recruitment.click();

		WebElement add = driver
				.findElement(By.xpath(("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
		add.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement firstname1 = driver.findElement(By.xpath("//*[@name=\'firstName\']"));
		firstname1.sendKeys(firstname);

		WebElement middlename1 = driver.findElement(By.xpath("//*[@name=\'middleName\']"));
		middlename1.sendKeys(middlename);

		WebElement lastname1 = driver.findElement(By.xpath("//*[@name=\'lastName\']"));
		lastname1.sendKeys(lastname);

		WebElement vacancy = driver.findElement(By
				.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[2]/i"));
		vacancy.click();

		List<WebElement> list = driver.findElements(By.xpath(
				"//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[2]/i/div[2]/div"));
		System.out.println("LIST" + list.size());
		for (WebElement wemainmenu : list) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("Associate IT Manager")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;
			}
		}

		WebElement email1 = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input"));
		email1.sendKeys(email);

		WebElement phoneNo = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input"));
		phoneNo.sendKeys(phoneno);

		WebElement resume1 = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div/div/div/div[2]/div/i"));
		resume1.click();
		StringSelection resume1path = new StringSelection("E:\\SHARMA'S\\resume\\res.pdf\\");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(resume1path, null);

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
		WebElement keyword1 = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[1]/div/div[2]/input"));
		keyword1.sendKeys(keyword);

		WebElement notes1 = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[6]/div/div/div/div[2]/textarea"));
		notes1.sendKeys(notes);

		WebElement consent = driver.findElement(By.xpath(
				("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[7]/div/div/div/div[2]/div/label/span/i")));
		consent.click();

		WebElement save = driver
				.findElement(By.xpath(("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[8]/button[2]")));
		save.click();

	}

}
