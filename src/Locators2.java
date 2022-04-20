import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name = "abc";
		
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // this wait applicable to every steps.
		
		String password = getPassword(driver);
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name); // by id
		//driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();	
		//Thread.sleep(1000);
		driver.findElement(By.name("inputPassword")).sendKeys(password); // by name
		//Thread.sleep(1000);
		driver.findElement(By.className("signInBtn")).click();	// by class name
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.quit();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException	{

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		String passwordText = driver.findElement(By.cssSelector("form p")).getText();

		//Please use temporary password 'rahulshettyacademy' to Login.
		
		String[] passwordArray= passwordText.split("'");
		
		//0th index - Please use temporary password '
		
		//1st index - rahulshettyacademy' to Login.

		String password = passwordArray[1].split("'") [0];
		
		//0th index -rahulshettyacademy
		
		//1st index - ' to Login.
		
		return password;

	}

}