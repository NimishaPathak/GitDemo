import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Section13_109_BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		// broken URL
		// Step 1 - is to get all the urls tied up to the links using selenium
		// step 2 - Java method will call URLs and gets you status code
		// if status code is >400 then that URL is not working -> it means link tied to URL is broken
		// css path in dev tools - console --> ('a[href*="soapui"]')
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Verify all the links in footer page and check whether any link is broken or not
		// When any link is broken and due to assertion script stops but even if assertion fails, you want to continue code to run
		// Use SOFT ASSERTION using testng jar dependency - go to maven repository -- import latest STABLE testng jar and import in your project
		List<WebElement> footerLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : footerLinks)
		{
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			
			// SOFT ASSERTION
			a.assertTrue(responseCode<400, "The link with text " + link.getText() + " is broken with code: " + responseCode);
			
//			if(responseCode>400)
//			{
//				System.out.println("The link with text " + link.getText() + " is broken with code: " + responseCode);
//				Assert.assertTrue(false);
//			}	
		}
		// SOFT ASSERTION
		a.assertAll();
		
		driver.quit();
	}
}