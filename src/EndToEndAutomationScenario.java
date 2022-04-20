import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class EndToEndAutomationScenario {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//return date calender enable / disable check		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		//radio option
		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		Thread.sleep(1000);
		//COMMENT --- driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		//COMMENT --- Parent-child relationship xpath for dynamic drop-down
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight ui-state-hover']")).click();
		
		//Assert whether return calender enable or disable
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		//driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		
		
//		   String Day = "5";
//	        String Month = "March";
//	        while (true)
//	        {
//	            if (!driver.getPageSource().contains(Month) || Month.equals("March"))
//	            {
//	            	driver.findElement(By.xpath("//span[text()='Next']")).click();
//	            } else
//	            {
//	            	driver.findElement(By.xpath("//span[text()='" + Month + "']//following::a[text()=" + Day + "]")).click();
//	                break;
//	            }
//	            System.out.println("Hello");
//	            if (driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals("December"))
//	            {
//	            	driver.findElement(By.xpath("//span[text()='December']//following::a[text()=" + Day + "]")).click();
//	                break;
//	            }
//
//	        }
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();
}
}
