package Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class verifybrandlogo {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup WebDriver (this can be managed by WebDriverManager)
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testBrandLogoVisibilityAndClick() {
        // Open the website
        driver.get("https://www.kimballinternational.com/");

        // Use WebDriverWait to wait for the logo to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.hidden-lg-down.d-none.d-lg-block")));

        // Verify if the brand logo is visible and enabled (clickable)
        Assert.assertTrue(logo.isDisplayed(), "Brand logo is not visible.");
        Assert.assertTrue(logo.isEnabled(), "Brand logo is not enabled.");

        // Try clicking the logo
        try {
            logo.click();
            System.out.println("Brand logo clicked successfully.");
        } catch (Exception e) {
            System.out.println("Error while clicking the brand logo: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test is finished
        if (driver != null) {
            driver.quit();
        }
    }
}
