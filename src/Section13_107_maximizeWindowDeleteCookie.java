import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Section13_107_maximizeWindowDeleteCookie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		// to maximize window
		driver.manage().window().maximize();
		
		// to delete all cookies
		driver.manage().deleteAllCookies();
		
		// to delete specific cookie
		driver.manage().deleteCookieNamed("specific cookie name");
		
		// to delete session cookie, and make sure user should be logged out and redirected to login page
		driver.manage().deleteCookieNamed("session cookie name here"); //1st step ---
		// 2nd step --- then click on any any link on website
		// 3rd step --- clicking on any link verify that user is redirected to login page or not
		
		driver.get("https://google.com");
		
	}

}
