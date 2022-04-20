import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		//implicit wait - it will wait up to specified seconds if not found the element then go to next step 
		//and if it found within specified seconds, it will go to next step.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // this wait applicable to every steps.
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("nimisha"); // by id
		driver.findElement(By.name("inputPassword")).sendKeys("123"); // by name
		driver.findElement(By.className("signInBtn")).click();		 // by class name
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); // by css selector
		
		driver.findElement(By.linkText("Forgot your password?")).click(); // by linktext
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("nimisha"); // by xpath
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("n@gmail.com"); // by css selector - using tag name
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear(); // by css selector - using index number
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("123456789");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("nimisha");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		//driver.quit();
	}
	
	

}
