import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.amazon.com.au/");
		Actions a = new Actions(driver);
		
		WebElement move1 = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		
		// moves to specific element
		a.moveToElement(move1).build().perform();
		// enters 'hello' word in capital letters and select the word using double click
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		a.moveToElement(move1).contextClick().build().perform(); // right click on the element
	}

}
