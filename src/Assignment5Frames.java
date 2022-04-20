import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment5Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href*='nested_frames']")).click();
		// System.out.println(driver.findElements(By.tagName("frame")).size());
		
		// YOU can do it either ABOVE way or BELOW way
		
		// driver.switchTo().frame(0);
		// System.out.println(driver.findElements(By.tagName("frame")).size());
		// driver.switchTo().frame(1);
		// System.out.println(driver.findElement(By.id("content")).getText());
		
		// YOU can do it either ABOVE way or BELOW way
		
		driver.switchTo().frame(0).switchTo().frame(1);
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.quit();
	}

}