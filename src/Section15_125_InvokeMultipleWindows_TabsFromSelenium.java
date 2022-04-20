import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Section15_125_InvokeMultipleWindows_TabsFromSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// SCENARIO
		// Navigate to https://rahulshettyacademy.com/angularpractice/"
		// Fill the "Name" field with the first course name available at
		// https://rahulshettyacademy.com/#/index -- this URL
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		
		// Get the first course name from the second window
		driver.get("https://rahulshettyacademy.com/#/index");
		String firstCourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		//Move to original page and enter course name in Name text box
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.name("name")).sendKeys(firstCourseName);
		
		driver.quit();		
	}

}