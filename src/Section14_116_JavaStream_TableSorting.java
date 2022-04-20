import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Section14_116_JavaStream_TableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		// Capture text of all the web elements into new list (original list)
		// Sort the original list --> you will get sorted list
		// Compare Original List vs Sorted List
		
		//Click on Column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// Capture all the WebElements in the list
		List<WebElement> columnList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = columnList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		// Sort the originalList
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		// Compare Original and Sorted List
		Assert.assertTrue(originalList.equals(sortedList));
		
		//Pagination concept using DO-WHILE Loop
		List<String> price;
		do
		{
			List<WebElement> columnList1 = driver.findElements(By.xpath("//tr/td[1]"));
			// Get the price of 'Beans' from the table where item is present on the first page only.
			//price = columnList1.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceOfRice(s)).collect(Collectors.toList());
			//// Get the price of 'Rice' which is not present on first page , so get the price of rice from the table
			price = columnList1.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceOfRice(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
		
			// Get the price of 'Rice' which is not present on first page , so get the price of rice from the table
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
		driver.quit();
	}

	private static String getPriceOfRice(WebElement s) {
		// TODO Auto-generated method stub
		// whole xpath is: //tr/td[1]/following-sibling::td[1] in which "//tr/td[1]" this part is already covered when filtering rice item above.
		String Itemprice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return Itemprice;
	}

}
