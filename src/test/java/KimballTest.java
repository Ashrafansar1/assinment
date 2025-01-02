import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KimballTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Set up Chrome options for headless mode (optional)
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Uncomment to run in headless mode

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver(options);
    }

    @Test
    public void testPageTitle() throws InterruptedException {
        // Open the URL
        driver.get("https://www.kimballinternational.com/");

        // Wait for the page to load (use WebDriverWait in production)
        Thread.sleep(5000); // Adjust time as necessary

        // Check if the title contains "Kimball International"
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Kimball International"), "Page title is incorrect.");
    }

    @Test(dependsOnMethods = "testPageTitle")
    public void testLogoPresence() {
        // Check for the presence of the logo
        WebElement logo = driver.findElement(By.cssSelector("img[class='hidden-lg-down d-none d-lg-block']"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
