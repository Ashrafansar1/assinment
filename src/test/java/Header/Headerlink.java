package Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;

public class Headerlink {

    public static void main(String[] args) {
        // Setup ChromeDriver
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Maximize window and open the URL
        driver.manage().window().maximize();
        driver.get("https://www.kimballinternational.com/");

        
        try {
            // Pause for 2 seconds to allow the page to load
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find the element for the 'All Products' menu and hover over it
        WebElement element2 = driver.findElement(By.id("all-products"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element2).perform();

        // Find the 'Coming Soon' link and click it
        WebElement element1 = driver.findElement(By.id("coming-soon-2025"));
        element1.click();

        // Scroll down the page using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        try {
            for (int i = 0; i < 1; i++) { // Adjust the number of scrolls as needed
                // Scroll down by 5000 pixels
                js.executeScript("window.scrollBy(0, 5000)");
                Thread.sleep(1000); // Pause for 1 second for visibility
                // Scroll back to the top
                js.executeScript("window.scrollTo(0, 100)");
                Thread.sleep(1000); // Pause for 1 second for visibility
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser after the actions
        driver.quit();
    }
}
