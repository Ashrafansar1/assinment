package Header;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class VerticaLinkworkingfine {

    public static void main(String[] args) {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Open the website
        driver.get("https://www.kimballinternational.com/");
        
        // Locate the first element (verticals menu)
        WebElement element1 = driver.findElement(By.id("kii-verticals"));
        
        // Perform mouse hover on the element
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).perform();
        
        // Locate the second element (Workplace menu item)
        WebElement element2 = driver.findElement(By.id("verticals-workplace"));
        element2.click();
        
        // Take a screenshot
        try {
            // Cast the driver to TakesScreenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // Define the destination folder and file path
            File screenShotFolder = new File("ScreenShot");
            if (!screenShotFolder.exists()) {
                // Create the folder if it doesn't exist
                screenShotFolder.mkdirs();
            }

            // Save the screenshot in the ScreenShot folder
            File destinationFile = new File(screenShotFolder, "screenshot.png");
            FileUtils.copyFile(screenshotFile, destinationFile);
            System.out.println("Screenshot saved as " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the driver
        driver.quit();
    }
}