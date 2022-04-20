import java.time.Duration;
import java.util.List;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		String text = driver.findElement(By.cssSelector("p.text-center.text-white")).getText();
		//System.out.println(text);
		
		String[] splitText = text.split(" ");
		//System.out.println(splitText[2]);
		
		String trimmedTex = splitText[6].replace(")", "");
		//System.out.println(trimmedTex);
		
		driver.findElement(By.id("username")).sendKeys(splitText[2]);
		driver.findElement(By.id("password")).sendKeys(trimmedTex);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click(); // Relative xpath
		// Explicit Wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='modal-content']")));
		//System.out.println(driver.findElement(By.cssSelector("div[class='modal-content']")).getText());
		driver.findElement(By.xpath("//div[@class='modal-footer justify-content-center']/button[2]")).click();
		WebElement profile = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select profileName = new Select(profile);
		profileName.selectByIndex(2);
		//System.out.println(profileName.getFirstSelectedOption().getText());
		driver.findElement(By.xpath("//label[@class='text-info']/span/input[@id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		// Explicit Wait
//		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(2));
//		w1.until(ExpectedConditions.);
		
		// Add button xpath: - "//button[@class='btn btn-info']"
	
		
		
	}

}
