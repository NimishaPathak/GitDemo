import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class checkboxExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Check option 1 checkbox and verify if it is successfully checked 
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		
		//Uncheck option 1 checkbox again to verify if it is successfully Unchecked
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
		
		//How to get the Count of number of check boxes present in the page
		System.out.println(driver.findElements(By.cssSelector("div[id='checkbox-example'] fieldset label input[type='checkbox']")).size());
		
		List<WebElement> checkboxNames = driver.findElements(By.cssSelector("div[id='checkbox-example'] fieldset label"));
		
		for(WebElement option: checkboxNames)
		{
			System.out.println(option.getText());
		}
		
		driver.quit();
	}

}