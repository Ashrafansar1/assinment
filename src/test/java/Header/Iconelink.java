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

public class Iconelink {

    public static void main(String[] args) {
        // Set up WebDriver
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kimballinternational.com/");

        // Wait for the page to load completely
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Scroll down the page using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            Thread.sleep(2000); // Wait to ensure the page is loaded
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Try to dismiss the cookie consent popup (if visible)
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-close-btn-container")));
            closeButton.click();  // Close the cookie consent banner
            System.out.println("Cookie consent popup closed.");
        } catch (Exception e) {
            System.out.println("No cookie consent popup found.");
        }

        // Scroll and find the image element
        for (int i = 0; i < 1; i++) {
            js.executeScript("window.scrollBy(0, 5000)");

            // Wait for the image to be clickable
            try {
                WebElement imgElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Kimball International']")));
                
                // Ensure the element is in view before clicking
                js.executeScript("arguments[0].scrollIntoView(true);", imgElement);

                imgElement.click();  // Click on the image
                System.out.println("Image clicked successfully.");
                break; // Exit after the image click is successful
            } catch (Exception e) {
                System.out.println("Image not clickable or not found.");
            }

            // Sleep to give the page time to load more content
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Close the browser after testing
        driver.quit();
    }
}
