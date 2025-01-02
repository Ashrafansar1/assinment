import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Functionaltesting {
    public static void main(String[] args) {
        // Set the path to your WebDriver executable
    	 WebDriverManager.chromedriver().setup();
 // Update with your path

        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("http://www.kimballinternational.com");

            // Assert the title of the page
            assert driver.getTitle().contains("Kimball International") : "Title does not match!";

            // Check if the logo is displayed
            WebElement logo = driver.findElement(By.xpath("//img[@alt='Kimball International Logo']"));
            assert logo.isDisplayed() : "Logo is not displayed!";

            // Click on a navigation link (e.g., Products)
            WebElement productsLink = driver.findElement(By.id("all-products"));
            productsLink.click();

            // Wait for the page to load
            Thread.sleep(3000); // Consider using WebDriverWait for better practices

            // Assert the URL of the current page
            assert driver.getCurrentUrl().contains("all-products") : "URL does not match!";

            // Check for a specific element on the Products page
            WebElement productSection = driver.findElement(By.xpath("//h1[contains(text(), 'all-products')]"));
            assert productSection.isDisplayed() : "Products section is not displayed!";

            System.out.println("All functional tests passed!");

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            // Close the browser
           // driver.quit();
        }
    }
}
