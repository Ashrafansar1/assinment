package Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.StaleElementReferenceException;
import java.time.Duration;

public class Highlighted {

    public static void main(String[] args) {
        // Initialize WebDriver and open the browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kimballinternational.com/");

        // Create a WebDriverWait to handle waiting for elements to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the first element (kii-verticals) and hover over it to trigger hover effects (optional)
        WebElement element1 = driver.findElement(By.id("kii-verticals"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).perform();

        // Locate and wait for the second element (verticals-workplace) to be clickable
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("verticals-workplace")));

        // Get the initial background color of element2 before clicking
        String initialBgColor = element2.getCssValue("background-color");
        System.out.println("Initial background color: " + initialBgColor);

        // Click the second element (verticals-workplace)
        element2.click();

        // Wait for the element to be available again after the click
        WebElement elementAfterClick = null;
        try {
            elementAfterClick = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("verticals-workplace")));
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException caught. Re-locating element.");
        }

        // Retry locating the element and getting the background color if needed
        if (elementAfterClick != null) {
            String afterClickBgColor = elementAfterClick.getCssValue("background-color");
            System.out.println("Background color after click: " + afterClickBgColor);

            // Check if the background color changed (indicating a click effect)
            if (!initialBgColor.equals(afterClickBgColor)) {
                System.out.println("The element's color changed upon click.");
            } else {
                System.out.println("The element's color did not change upon click.");
            }
        } else {
            System.out.println("Element is not found after click or was stale.");
        }

        // Close the browser
        driver.quit();
    }
}
