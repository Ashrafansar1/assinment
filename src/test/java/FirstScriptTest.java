import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstScriptTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Automatically set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kimballinternational.com/home");
    }

    @Test
    public void testNavigationAndScroll() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on various elements in sequence
        clickElement(wait, By.id("all-products"));
        clickElement(wait, By.cssSelector("a#spaces.nav-link"));
        clickElement(wait, By.cssSelector("#kii-verticals"));
        clickElement(wait, By.cssSelector("#resources"));
        clickElement(wait, By.cssSelector("#insights"));
        clickElement(wait, By.cssSelector("#brands"));
        clickElement(wait, By.cssSelector("#about"));

        // Scroll down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 5000);");
        Thread.sleep(1000); // Pause for visibility
        js.executeScript("window.scrollTo(0, 0);"); // Scroll to the top
        Thread.sleep(1000); // Pause for visibility
    }

    private void clickElement(WebDriverWait wait, By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        Thread.sleep(1000); // Pause for visibility
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Ensure the browser closes
        }
    }
}
