import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Section15_Selenium4_NewFeatures_RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// Relative Locator -- ABOVE -- label 'Name'
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name'"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		// Relative Locator -- BELOW -- Date Of Birth edit box
		WebElement dateOfBirthLabel = driver.findElement(By.cssSelector("[for='dateofBirth'"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirthLabel)).click();
		
		// Relative Locator -- LEFT -- check-box mentioned besides text mentioned 'Check me out if you Love IceCreams!'
		WebElement textofCheckBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(textofCheckBox)).click();
		
		// Relative Locator -- RIGHT -- get the radio button name of radio button - Student
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
		
		
		
		//driver.quit();
	}

}