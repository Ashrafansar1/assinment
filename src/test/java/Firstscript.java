import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Firstscript {
    public static void main(String[] args) {
        // Automatically set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Open the URL
            driver.get("https://www.kimballinternational.com/home");

            // Set up a wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the first element to be visible and then clickable
            WebElement firstElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("all-products")));
            firstElement.click();
            Thread.sleep(1000);

            // Wait for the second element and click it
            WebElement secondElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#spaces.nav-link")));
            secondElement.click();
            Thread.sleep(1000);

            // Wait for the third element and click it
            WebElement thirdElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#kii-verticals")));
            thirdElement.click();
            Thread.sleep(1000);

            // Wait for the fourth element and click it
            WebElement fourthElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#resources")));
            fourthElement.click();
            Thread.sleep(1000);

            // Wait for the fifth element and click it
            WebElement fiveElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#insights")));
            fiveElement.click();
            Thread.sleep(1000);

            // Wait for the sixth element and click it
            WebElement sixElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#brands")));
            sixElement.click();
            Thread.sleep(1000);

            // Wait for the seventh element and click it
            WebElement sevenElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#about")));
            sevenElement.click();

            // Scroll down the page
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 0; i < 1; i++) { // Adjust the number of scrolls as needed
                // Scroll down by 500 pixels
                js.executeScript("window.scrollBy(0, 5000)");
                Thread.sleep(1000); // Pause for visibility (adjust as needed)
                js.executeScript("window.scrollTo(0,100);"); // Corrected to scroll to the top
                Thread.sleep(1000); // Pause for visibility

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            //driver.quit(); // Uncomment this line to ensure the browser closes
        }
    }
}
