import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
public class footer {
    public static void main(String[] args) {
        
    
        WebDriver driver = new ChromeDriver();
        try {
           
            driver.get("https://www.kimballinternational.com/home");
           
            Thread.sleep(2000); 
            
            WebElement footer = driver.findElement(By.tagName("footer"));
            // Find all <a> elements within the footer
            List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
            // Check if links are found
            if (footerLinks.isEmpty()) {
                System.out.println("No links found in the footer.");
            } else {
                // Print each link's text and href attribute
                for (WebElement link : footerLinks) {
                    String linkText = link.getText();      
                    String linkHref = link.getAttribute("href"); 
                    // Print the link details
                    System.out.println("Link Text: " + linkText);
                    System.out.println("Link URL: " + linkHref);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            driver.quit();
        }
    }
}