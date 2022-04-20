import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment8_Section12 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Enter text 'ind' and using DOWN arrow key from keyboard, go to India Option and select it and print in console
		
		driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		
		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li[@class='ui-menu-item']/div"));

		for(WebElement option : options)

		{
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
				
		// when SENDKEYS does not work, use GETATTRIBUTE("VALUE").
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
				
		driver.quit();
	}

}