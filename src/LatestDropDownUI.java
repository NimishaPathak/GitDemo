import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LatestDropDownUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//STATIC DROP-DOWNS
		
//		driver.findElement(By.id("divpaxinfo")).click();
//		Thread.sleep(2000L);
//		
//		int a = 1;
//		while(a<2)
//		{
//			driver.findElement(By.id("hrefIncAdt")).click();
//			a++;
//		}
//		for(int c=0; c<4; c++)
//		{
//			driver.findElement(By.id("hrefIncChd")).click();
//		}
//		int i = 0;
//		while(i<2)
//		{
//			driver.findElement(By.id("hrefIncInf")).click();
//			i++;
//		}
//		for(int h=4; h>=3; h--)
//		{
//			driver.findElement(By.id("hrefDecChd")).click();
//		}
//		driver.findElement(By.id("btnclosepaxoption")).click();
//		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//DYNAMIC DROP-DOWNS
		
//		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
//		Thread.sleep(1000);
//		//COMMENT --- driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
//		
		//COMMENT --- Parent-child relationship xpath for dynamic drop-down
//		//driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		//AUTO SUGGESTIVE DROP-DOWNS
		
		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li[@class='ui-menu-item']/a"));
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				System.out.println(option.getText());
				option.click();
			}
		}
		
		driver.quit();
	}

}
