import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(2000);		
		driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']")).sendKeys("DemoName");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("demoName@protractortutorial.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("demo@protractor");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement gender = driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
		Select option = new Select(gender);
		option.selectByVisibleText("Female");
		driver.findElement(By.cssSelector("input[id='inlineRadio1']")).click();
		driver.findElement(By.name("bday")).sendKeys("29/01/2022");
		driver.findElement(By.cssSelector("input[class*='btn-success']")).click();

		System.out.println(driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
		
		driver.quit();
	}

}
