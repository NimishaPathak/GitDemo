import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Section15_127_CapturingHeightWidthOfEWebElement {

	public static void main(String[] args) throws IOException {
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
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(firstCourseName);
		
		// Take screenshot of Name field
		File file = name.getScreenshotAs(OutputType.FILE);
		
		// Download jar from this location to download file object into physical file copy -- IF ITS not available already
		// https://mvnrepository.com/artifact/commons-io/commons-io/2.5
		FileUtils.copyFile(file, new File("name.png"));
		
		// After running test, refresh project repository, you will find your screenshot file.
		
		// Get Height and Width of Name field
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
	}

}
