package Header;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class SocialIcon {

    public static void main(String[] args) {
        // Setup WebDriver with WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            // Maximize window and open the URL
            driver.manage().window().maximize();
            driver.get("https://www.kimballinternational.com/");

            // Initialize WebDriverWait with the modern approach (using Duration)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll down by 5000 pixels
            js.executeScript("window.scrollBy(0, 5000)");
            Thread.sleep(1000); // Pause for 1 second for visibility

            // Wait until the Facebook image is clickable (based on alt text)
            WebElement facebookImage = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Facebook Icon']"))
            );

            // Click the Facebook image
            facebookImage.click();
            System.out.println("Facebook icon clicked successfully.");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
