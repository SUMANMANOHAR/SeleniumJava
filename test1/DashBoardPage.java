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
import org.openqa.selenium.interactions.Actions;

public class DashBoardPage {

	WebDriver driver;

	By userPIM = By.xpath("//ul[@class='oxd-main-menu']//li[2]");
	By userMyInfo = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span");
	By userRecruitment = By.xpath("//span[text()='Recruitment']");

	public void DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickPIM() {
		driver.findElement(userPIM).click();
	}

	public void clickMyInfo() {
		driver.findElement(userMyInfo).click();
	}

	public void clickRecruitment() {
		driver.findElement(userRecruitment).click();
	}

}
