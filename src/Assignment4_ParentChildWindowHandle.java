import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment4_ParentChildWindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		// driver.findElement(By.cssSelector("a[href*='windows']")).click();

		// get Text from new window / child window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		// System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
		// switch back to parent window
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		// System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
		
		driver.quit();
	}

}
