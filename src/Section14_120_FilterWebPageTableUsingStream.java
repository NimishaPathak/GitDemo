import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Section14_120_FilterWebPageTableUsingStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// Filter or Search text box Functionality
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> vegFruitList = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredList = vegFruitList.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(vegFruitList.size(), filteredList.size());
		
		driver.quit();
	}

}
