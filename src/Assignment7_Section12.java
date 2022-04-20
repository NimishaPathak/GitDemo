import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class Assignment7_Section12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Total No. of Rows

		int totalRows = driver.findElements(By.cssSelector(".table-display tr")).size();

		System.out.println("Total no. of rows: " + totalRows);

		// Total No. of Columns

		int totalColumns = driver.findElements(By.cssSelector(".table-display th")).size();

		System.out.println("Total no. of columns: " + totalColumns);

		// Data in Second row

		List<WebElement> secondRow = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));

		int j = 1;

		for(int i=0;i<secondRow.size();i++)

		{

		System.out.println("Second Row Data in "+ j +" column is "+ secondRow.get(i).getText());

		j++;

		}
		
//        for(WebElement data : SecondRow)
//        {
//            System.out.println(data.getText());
//        }
		
		// OR YOU CAN WRITE ASSIGNMENT BY BELOW WAY USED BY INSTRUCTOR IN VIDEO
		
//		WebElement table=driver.findElement(By.id("product"));
//
//
//
//		System.out.println(table.findElements(By.tagName("tr")).size());
//
//
//
//		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
//
//
//
//		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
//
//
//
//		System.out.println(secondrow.get(0).getText());
//
//
//
//		System.out.println(secondrow.get(1).getText());
//
//
//
//		System.out.println(secondrow.get(2).getText());

	}

}