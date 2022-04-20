import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// 1. Select any checkbox and get the label of selected checkbox
		// 2. Select the same option from drop-down box which you have selected from checkbox
		// 3. Enter the same text in Switch to Alert Example text box.
		// 4. Click on <Alert> button and verify popup message contains that text or not
		
		// Answer to 1st question
		driver.findElement(By.id("checkBoxOption2")).click();
		// driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		
		// Answer to 2nd question
		String label = driver.findElement(By.cssSelector("div[id='checkbox-example'] fieldset label[for='benz']")).getText();
		// String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		
		System.out.println(label);
		
		WebElement staticdropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdownOption = new Select(staticdropdown);

		dropdownOption.selectByVisibleText(label);
		
		// Answer to 3rd question
		driver.findElement(By.id("name")).sendKeys(label);
		
		// Answer to 4th question
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contains(label))
		{
			System.out.println(label + " is present in alert message.");
		}
		else
		{
			System.out.println(label + " is not present in alert message.");
		}
		driver.switchTo().alert().accept();
		
		driver.quit();
	}

}
