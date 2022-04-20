import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Section12_Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		
		// Declare javascript class executor object
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// scroll WINDOW using javascript script
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(3000);
		
		// scroll TABLE vertically
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		// sum of Amount field in 'web Table Fixer Header'
		List<WebElement> amountValues = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for(int i = 0; i<amountValues.size();i++)
		{
			 sum = sum + Integer.parseInt(amountValues.get(i).getText());
		}
		
		// System.out.println("Total Amount is: " + sum);
		
		// Compare Amount total you get above with the total mentioned on web page below table named 'web Table Fixer Header'
		
		Integer ActualTotalAmountOnWeb = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, ActualTotalAmountOnWeb);
		
	}

}
