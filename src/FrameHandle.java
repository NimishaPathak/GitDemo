import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		// switch to frame in web page using web element
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		// switch to frame in web page using index number
		driver.switchTo().frame(0);
		
		// drag and drop frame from one location to another location
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		
		// To switch from frames to normal window element
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Accept")).click();
		
		driver.quit();
	}

}
