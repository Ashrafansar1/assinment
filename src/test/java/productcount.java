import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class productcount {
    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://www.kimballinternational.com/idea-starters");

        // Create a JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        // Scroll until no new products are loaded
        while (true) {
            // Scroll top to the bottom
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for new products to load
            try {
                Thread.sleep(5000); // Adjust the sleep time if necessary
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Calculate new height and compare with last height
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break; // Exit the loop if no new products are loaded
            }
            lastHeight = newHeight;
        }

        // Now count the products as before
        List<WebElement> products = driver.findElements(By.xpath("//img[@class='w-100']")); // Adjust class name as necessary
        System.out.println("Total number of products: " + products.size());

        // Close the driver
        driver.quit();
    }
}
