import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Task - Take a partial screenshot of the WebElement
 *
 * Step 1: Go to https://rahulshettyacademy.com/angularpractice/
 * Step 2: Write text into Name input box
 * Step 3: Take a partial screenshot of the page
 */
public class PartialScreenshot {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameInput = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
        nameInput.sendKeys("Jooah Seo");

        // take screenshot - save it in the project
        File sourceFile = nameInput.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("name.png"));

        Thread.sleep(3000);
        driver.quit();
    }
}
