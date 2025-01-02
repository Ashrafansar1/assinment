package MaterialLibraryPLP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class FilterFunctionality {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        // Setup WebDriver (with WebDriverManager for ChromeDriver version management)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testFilterFunctionality() {
        // Navigate to the target website
        driver.get("https://www.kimballinternational.com/home");
        
        // Wait until the page is loaded properly and the "Resources" button is visible
        WebElement resourcesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resources")));
        resourcesButton.click();
        
        // Wait for and click "Material Library" button
        WebElement materialLibraryButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("material-library")));
        materialLibraryButton.click();
        
        // Wait for the filter button to be visible and clickable
        WebElement filterButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter_button")));
        filterButton.click();
        
        // Wait for the "Interwoven" filter option to be visible and clickable
        WebElement interwovenFilter = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-hidden='true']")));
        
        // Scroll the "Interwoven" filter element into view if necessary
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", interwovenFilter);
        
        // Click on the "Interwoven" filter
        interwovenFilter.click();
        
        // Wait for some visual cue or change in the UI that confirms the filter was applied (e.g., results update)
        // For now, we check if the filter appears as selected (or a change in results occurs)
        WebElement appliedFilterIndicator = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".applied-filter-indicator")));  // Change this selector to match the actual element
        
        // Check if filter is applied successfully by verifying the indicator
        if (appliedFilterIndicator.isDisplayed()) {
            System.out.println("Filter applied successfully!");
        } else {
            System.out.println("Filter not applied successfully.");
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the action is performed
        if (driver != null) {
            driver.quit();
        }
    }
}
