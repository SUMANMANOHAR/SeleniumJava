package test1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInfoPage {
	WebDriver driver;
	By myInfo = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a");
	By nickName = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div[2]/input");
	By empId1 = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input");
	By otherId1 = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input");
	By drivingLicence = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input");
	By ssnNo = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[1]/div/div[2]/input");
	By sinNo = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[2]/div/div[2]/input");
	By Nationality = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i");
	By NationalitySelect = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i/div[2]/div");
	By maritalStatus = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[2]/i");
	By maritalStatusSelect = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[2]/i/div[2]/div");
	By militaryService = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[1]/div/div[2]/input");
	By save = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button");
	By bloodType = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div/div/div[2]/i");
	By bloodTypeSelect = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div/div/div[2]/i/div[2]/div");
	By save1 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/button");
	By add = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div/button");
	By browse = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[1]/div/div/div/div[2]/div/i");

	By comment1 = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[2]/div/div/div/div[2]/textarea");
	By save2 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]");

	public MyInfoPage(WebDriver driver)

	{

		this.driver = driver;

	}

	public void personalDetails() throws Exception

	{
		Properties ppt = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\project1\\datadriven\\test3.properties");
		ppt.load(fis);

		String nickname = ppt.getProperty("nickname");
		String empId = ppt.getProperty("employeeId");
		String otherId = ppt.getProperty("otherId");
		String militaryservice = ppt.getProperty("militaryservice");
		String drivinglicence = ppt.getProperty("drivinglicence");
		String ssnno = ppt.getProperty("ssnno");
		String sinno = ppt.getProperty("sinno");
		String comment = ppt.getProperty("comment");

		driver.findElement(myInfo).click();

		driver.findElement(nickName).sendKeys(nickname);

		driver.findElement(empId1).sendKeys(empId);
		driver.findElement(otherId1).sendKeys(otherId);

		driver.findElement(drivingLicence).sendKeys(drivinglicence);
		driver.findElement(ssnNo).sendKeys(ssnno);
		driver.findElement(Nationality).click();

		java.util.List<WebElement> list1 = driver.findElements(NationalitySelect);
		System.out.println("LIST" + list1.size());
		for (WebElement wemainmenu : list1) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("indian")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;
			}
		}

		driver.findElement(maritalStatus).click();
		java.util.List<WebElement> list12 = driver.findElements(maritalStatusSelect);
		System.out.println("LIST" + list12.size());
		for (WebElement wemainmenu : list12) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("Single")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;

			}
		}

		driver.findElement(militaryService).sendKeys(militaryservice);
		driver.findElement(save).click();
		driver.findElement(bloodType).click();

		java.util.List<WebElement> list13 = driver.findElements(bloodTypeSelect);
		System.out.println("LIST" + list13.size());
		for (WebElement wemainmenu : list13) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("B+")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;
			}
		}
		driver.findElement(save1).click();
		driver.findElement(add).click();
		driver.findElement(browse).click();
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

			driver.findElement(comment1).sendKeys(comment);
			driver.findElement(save2).click();

		}
	}

}