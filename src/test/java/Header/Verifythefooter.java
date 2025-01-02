package Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class Verifythefooter {

    public static void main(String[] args) {
        // Set up WebDriver
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.kimballinternational.com/");

        // Find all links in the footer (assuming footer has a specific class or ID)
        List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));

        // Flag to track if Privacy Policy link is found
        boolean privacyPolicyFound = false;

        // Iterate through all footer links and check if "Privacy Policy" is present
        for (WebElement link : footerLinks) {
            if (link.getText().equals("Privacy Policy")) {
                privacyPolicyFound = true;
                break; // No need to check further, link found
            }
        }

        // Verify if "Privacy Policy" link is found in footer
        if (privacyPolicyFound) {
            System.out.println("Privacy Policy link is present in the footer");
        } else {
            System.out.println("Privacy Policy link not present in the footer");
        }

        // Optional: click the link if needed
        // if (privacyPolicyFound) {
        //     WebElement privacyPolicyLink = driver.findElement(By.linkText("Privacy Policy"));
        //     privacyPolicyLink.click();
        //     System.out.println("Privacy Policy Link successfully clicked");
        // }

        // Close the browser
        driver.quit();
    }
}
