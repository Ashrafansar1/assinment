package Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VerticaLinkworkingfine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kimballinternational.com/");
        WebElement element1 = driver.findElement(By.id("kii-verticals"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).perform();
        WebElement element2=driver.findElement(By.id("verticals-workplace"));
        element2.click();
	}

}
