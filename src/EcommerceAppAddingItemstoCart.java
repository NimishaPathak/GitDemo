import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceAppAddingItemstoCart {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		System.setProperty("webdriver.Edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise");

		String[] itemsToCart = { "Brocolli", "Cucumber", "Beetroot" };
		
		// if you do not create static method then use below 2 lines
		// EcommerceAppAddingItemstoCart e = new EcommerceAppAddingItemstoCart();	
		// e.addItems(driver, itemsToCart);
		
		//if you have created static method, use below way to use method
		addItems(driver, itemsToCart);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		// EXPLICIT WAIT
		// WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		// w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		

	}

	public static void addItems(WebDriver driver, String[] itemsToCart)
	{
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			// String name = products.get(i).getText();

			// trim name to remove "- 1 kg" from "Brocolli - 1 Kg" to compare whether it
			// matches our selected "itemsToCart"
			String[] name = products.get(i).getText().split("-");
			// from above we will get 2 strings - name[0] is: "Brocolli "
			// name[1]: " 1 Kg"
			String extactItemName = name[0].trim(); // to trim white space from vegetable name "Brocolli " to "Brocolli"

			// check whether name you extracted are present in array or not
			// convert 'itemsToCart' array into Array List for easy search
			List itemList = Arrays.asList(itemsToCart);

			// Once items from "itemsToCart" string list is added to cart then how to stop
			// if loop ton run from 30 times?
			int j = 0;

			// if(name.contains("Cucumber"))
			if (itemList.contains(extactItemName)) {
				j++;
				// then click on 'ADD TO CART' button
				driver.findElements(By.cssSelector("div.product-action button")).get(i).click();

				// break; break can be used when there is only one item.

				// Once items from "itemsToCart" string list is added to cart then how to stop
				// if loop ton run from 30 times?
				if (j == itemsToCart.length) {
					break;
				}
			}
		}

	}
}
