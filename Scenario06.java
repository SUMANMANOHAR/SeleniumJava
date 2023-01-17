package project1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario06 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\eclipse-java-2022-06-R-win32-x86_64\\eclipse\\TestAutomationBatchJuly17\\src\\test\\java\\scenario06.properties");
		p.load(fis);

		String url_data = p.getProperty("url");
		String username = p.getProperty("username");
		String pw_data = p.getProperty("password");
		String loginPath = p.getProperty("login");
		String vacancyname = p.getProperty("vacancyname");
		String description = p.getProperty("description");
		String hiringmanager = p.getProperty("hiringmanager");
		String noofposition = p.getProperty("noofposition");
		

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

		WebElement vacancies = driver
				.findElement(By.xpath(("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]")));
		vacancies.click();

		WebElement add = driver
				.findElement(By.xpath(("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
		add.click();

		WebElement vacancyName1 = driver.findElement(
				By.xpath(("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/input")));
		vacancyName1.sendKeys(vacancyname);

		WebElement jobDropdown = driver.findElement(By.xpath(
				("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/div[2]/i")));
		jobDropdown.click();

		List<WebElement> list = driver.findElements(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/div[2]/i/div[2]/div"));
		System.out.println("LIST" + list.size());
		for (WebElement wemainmenu : list) {
			System.out.println("WE" + wemainmenu.getText());
			if (wemainmenu.getText().equals("Chief Executive Officer")) {
				System.out.println("HELLO" + wemainmenu.getText());
				wemainmenu.click();
				break;

			}
		}

		WebElement description1 = driver.findElement(
				By.xpath(("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div[2]/textarea")));
		description1.sendKeys(description);

		WebElement hiringManager1 = driver.findElement(By
				.xpath(("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[1]/div/div[2]/div/div/input")));
		hiringManager1.sendKeys(hiringmanager);

		WebElement noOfPosition1 = driver.findElement(By
				.xpath(("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[2]/div/div/div/div[2]/input")));
		noOfPosition1.sendKeys(noofposition);

		WebElement save = driver
				.findElement(By.xpath(("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[7]/button[2]")));
		save.click();

	}

}
