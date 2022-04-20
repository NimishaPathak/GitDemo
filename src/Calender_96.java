import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Calender_96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		
		// Select specific date dynamically -- August 23
		// grab the common attribute in calender html and iterate it to select specific date
		driver.findElement(By.id("travel_date")).click();
		
		// month selection logic -- August
		// While loop will continue executing till it becomes false
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("August"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		
		// Day -- 23 -- selection logic
		List<WebElement> dates = driver.findElements(By.className("day"));
		int totalDaysCount = driver.findElements(By.className("day")).size();
		
		for(int i = 0; i<totalDaysCount;i++)
		{
			String dayNumber = dates.get(i).getText();
			if(dayNumber.equalsIgnoreCase("23"))
			{
				dates.get(i).click();
				break;
			}
		}
	}

}
