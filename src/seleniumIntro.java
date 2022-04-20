import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class seleniumIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Invoking Browser
		//Edge - EdgeDriver - Methods
		// Setting system properties of EdgeDriver
		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");

		//Creating an object of EdgeDriver
		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		driver.quit();
		
		//USING CHROME
		//System.setProperty("webdriver.chrome.driver", "chrome driver .exe path");
		//WebDriver driver = new ChromeDriver(); import package related to chromedriver
		
		//FIREFOX LAUNCH
		// webdriver.gecko.driver
		//System.setProperty("webdriver.gecko.driver", "path to gecko driver.exe");
		//WebDriver driver = new FirefoxDriver();

	}

}
