package test1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VacancyPage {

	WebDriver driver;
	By recClick = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span");
	By vacancies = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a");
	By add = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	By vacancyName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/input");
	By jobTitle = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/div[2]/i");
	By jobTitleSelect = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/div[2]/i/div[2]/div");
	By description1 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div[2]/textarea");
	By hiringManager = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[1]/div/div[2]/div/div/input");
	By noOfPositions = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[2]/div/div/div/div[2]/input");
	By save = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[7]/button[2]");

	public VacancyPage(WebDriver driver)

	{

		this.driver = driver;

	}

	public void vacancyDetails() throws Exception {
		Properties ppt = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\project1\\datadriven\\test6.properties");
		ppt.load(fis);

		String vacancyname = ppt.getProperty("vacancyname");
		String description = ppt.getProperty("description");
		String hiringmanager = ppt.getProperty("hiringmanager");
		String noofposition = ppt.getProperty("noofposition");

		driver.findElement(recClick).click();
		driver.findElement(vacancies).click();

		driver.findElement(add).click();

		driver.findElement(vacancyName).sendKeys(vacancyname);

		driver.findElement(jobTitle).click();

		List<WebElement> list = driver.findElements(jobTitleSelect);
		System.out.println("LIST" + list.size());
		for (WebElement wemainmenu : list) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("Chief Executive Officer")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;

			}
		}

		driver.findElement(description1).sendKeys(description);

		driver.findElement(hiringManager).sendKeys(hiringmanager);

		driver.findElement(noOfPositions).sendKeys(noofposition);

		driver.findElement(save).click();

	}
}
