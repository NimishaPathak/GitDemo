import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;

public class Section13_108_TakeScreenshotInSelenium {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://google.com");
		
		// if you are not able to import FileUtils library, go to link https://commons.apache.org/proper/commons-io/ and from there download zip
		// extract zip and go to project property - java build path - add extral jars - all the jars and click <Apply and Close>
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\ndesa\\Nimisha\\Manual Testing\\Automation Testing\\Screenshots\\screenshot_section13_108.png"));
		
		driver.quit();
	}
}