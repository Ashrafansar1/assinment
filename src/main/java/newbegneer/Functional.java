package newbegneer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Functional {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kimballinternational.com/home");
    }

    @Test
    public void testNavigationAndScrolling() {
        // Click on first link
        WebElement firstElement = driver.findElement(By.cssSelector("#resources"));
        firstElement.click();

        // Wait for the second link to be clickable and then click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(23)); // Increase the timeout to 15 seconds
        WebElement secondElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("idea-starters")));
        secondElement.click();

        // Hover over the element with ID 'sort_button'
        WebElement elementToHover = driver.findElement(By.id("sort_button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();

        // Click on the 'Z-A' element
        WebElement fourElement = driver.findElement(By.id("Z-A"));
        fourElement.click();

        // Wait for the image element to be visible
        WebElement imgElement = null;
        try {
            imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.w-100")));
        } catch (Exception e) {
            System.out.println("Image element not found: " + e.getMessage());
        }

        if (imgElement != null) {
            imgElement.click();
        } else {
            System.out.println("Image element was not visible within the time frame.");
        }

        // Scroll until the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return document.documentElement.scrollHeight");

        while (true) {
            // Scroll down by a large value (for instance, to the bottom)
            js.executeScript("window.scrollBy(0, 4000);"); // Scroll down by 4000px

            // Wait for new content to load
            try {
                Thread.sleep(2500); // Adjust the sleep time if needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Get the new scroll height after scrolling
            long newHeight = (long) js.executeScript("return document.documentElement.scrollHeight");

            // If the new height is the same as the last height, we've reached the bottom
            if (newHeight == lastHeight) {
                break;
            }

            // Update the last height for the next iteration
            lastHeight = newHeight;
        }

        // Add a simple assertion to verify page title after scrolling
        Assert.assertTrue(driver.getTitle().contains("Kimball International"), "Page title does not contain 'Kimball International'.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
