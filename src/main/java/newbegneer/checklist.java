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

public class checklist {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kimballinternational.com/home");
    }

    @Test
    public void testKimballSite() {
        // First click
        WebElement firstElement = driver.findElement(By.cssSelector("#resources"));
        firstElement.click();

        // Wait for the second element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement secondElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("idea-starters")));
        secondElement.click();

        // Hover over "sort_button"
        WebElement elementToHover = driver.findElement(By.id("sort_button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();

        // Click on the "Z-A" option
        WebElement fourElement = driver.findElement(By.id("Z-A"));
        fourElement.click();

        // Wait for the element to be visible and clickable
        WebElement imgElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.w-100")));
        imgElement.click();

        // You can add assertions here to validate behavior (optional)
        // Example assertion: Check if the URL has changed after the click
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("kimballinternational"), "URL does not contain expected domain.");
    }

    @AfterMethod
    public void tearDown() {
        // Optionally, close the browser after the actions
        if (driver != null) {
            driver.quit();
        }
    }
}
