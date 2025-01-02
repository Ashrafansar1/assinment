import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class testng {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
   //     WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void countProducts() {
        driver.get("https://www.kimballinternational.com/idea-starters");
        
        // Use WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("w-100"))); // Correctly waiting for the presence of elements

        // Find product elements using the correct class name
        List<WebElement> productElements = driver.findElements(By.className("w-100"));
        int productCount = productElements.size();
        System.out.println("Number of products: " + productCount);

        // Optional: Assert to check if product count is greater than zero
        Assert.assertTrue(productCount > 0, "No products found!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
