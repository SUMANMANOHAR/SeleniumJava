package test1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecruitmentPage {

	WebDriver driver;
	By recClick = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a");
	By addClick = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	By firstName = By.xpath("//*[@name=\"firstName\"]");
	By middleName = By.xpath("//*[@name=\'middleName\']");
	By lastName = By.xpath("//*[@name=\'lastName\']");
	By vacancy = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[2]/i");
	By vacancySelect = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[2]/i/div[2]/div");
	By email1 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input");
	By phoneNo = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input");
	By resume1 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div/div/div/div[2]/div/i");
	By keyWord1 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[1]/div/div[2]/input");
	By notes1 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[6]/div/div/div/div[2]/textarea");
	By consentClick = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[7]/div/div/div/div[2]/div/label/span/i");
	By saveClick = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[8]/button[2]");

	public RecruitmentPage(WebDriver driver)

	{

		this.driver = driver;

	}

	public void addVacancies() throws Exception

	{
		Properties ppt = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\project1\\datadriven\\test5.properties");
		ppt.load(fis);

		String firstname = ppt.getProperty("firstname");
		String middlename = ppt.getProperty("middlename");
		String lastname = ppt.getProperty("lastname");
		String email = ppt.getProperty("email");
		String phoneno = ppt.getProperty("phoneno");
		String resume = ppt.getProperty("resume");
		String notes = ppt.getProperty("notes");
		String keyword = ppt.getProperty("keyword");
		String SELECT = ppt.getProperty("Select1");

		driver.findElement(recClick).click();

		driver.findElement(addClick).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(firstName).sendKeys(firstname);

		driver.findElement(middleName).sendKeys(middlename);

		driver.findElement(lastName).sendKeys(lastname);

		driver.findElement(vacancy).click();

		List<WebElement> list = driver.findElements(vacancySelect);
		System.out.println("LIST" + list.size());
		for (WebElement wemainmenu : list) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("Associate IT Manager")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;
			}
		}

		driver.findElement(email1).sendKeys(email);

		driver.findElement(phoneNo).sendKeys(phoneno);

		driver.findElement(resume1).click();
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

			driver.findElement(keyWord1).sendKeys(keyword);

			driver.findElement(notes1).sendKeys(notes);

			driver.findElement(consentClick).click();

			driver.findElement(saveClick).click();

		}
	}
}