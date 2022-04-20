import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Section13_HandleHTTPScertification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// to authorize or to get certificate for insecured https url
		EdgeOptions options = new EdgeOptions();
		options.setAcceptInsecureCerts(true);
		
		//If you need proxy at runtime, you can do it at below thing
		Proxy proxy = new Proxy();
		// 4444 is just for example. its not real ip address
		proxy.setHttpProxy("ipaddress:4444");
		
		options.setCapability("proxy", proxy);
		
		// to block pop-up windows, use below code
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		// to set download directory path to download anything
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "give directory path here");
		options.setExperimentalOption("prefs",prefs);
		
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver(options);

		driver.get("https://expirted.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}