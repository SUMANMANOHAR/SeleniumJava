package assignmentmodule1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioCheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get ("https://demo.guru99.com/test/radio.html");
		
		WebElement radioButton1= driver.findElement(By.id("vfb-7-1"));
		radioButton1.click();
		
		if(radioButton1.isDisplayed())
		{
			System.out.println("radio button is displayed");
		}
		
		WebElement checkBox2= driver.findElement(By.id("vfb-6-1"));
		checkBox2.click();
		
		if(checkBox2.isEnabled())
		{
			System.out.println("Checkbox 2 is Enabled");
		}
		
				//input[@id="vfb-7-2"]   to write xpath
		
				
//		WebElement radioButton2= driver.findElement(By.xpath("//input[@id='vfb-7-2']"));
//		radioButton2.click();
		
//		if(radioButton2.isSelected())
		{
			System.out.println("radioButton2 is selected");
		}
		
		
				
		WebElement checkBox3= driver.findElement(By.xpath("//*[@id='vfb-6-2']"));
		checkBox3.click();
				

	}

}
