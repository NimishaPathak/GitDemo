import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Section11_EndToEndWebDriverScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Give me the counts of links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// Give me the counts of links in FOOTER area of the page -- LIMITING webdriver scope
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		// Give me the counts of links from the first column of footer section
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table//tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		// click on each link in columndriver of footer and check wehter links are opening or not
		for(int i=1; i<columnDriver.findElements(By.tagName("a")).size();i++)
		{
			
			// to open each link in different tab
			String ClinkOnLinkToOpenInDifferentTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(ClinkOnLinkToOpenInDifferentTab);
			Thread.sleep(3000);
		}
		Set<String> links = driver.getWindowHandles(); //4 links
		Iterator<String> link = links.iterator();
		while(link.hasNext())
		{
			driver.switchTo().window(link.next());
			System.out.println(driver.getTitle());
		}
			
		
	}

}
