import Helper.ScreenController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Travel {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.koreanair.com/us/en");
        ScreenController helper = new ScreenController(driver);
        Actions action = new Actions(driver);

        //From -> select JFK
        WebElement fromBtn = driver.findElement(By.xpath("//button[contains(@id,'departureBtn')]"));
        fromBtn.click();
        By inputLocator = By.xpath("//input[@aria-owns='combobox-list']");
        helper.waitUntilLocatorExist(inputLocator);
        driver.findElement(inputLocator).sendKeys("JFK", Keys.ENTER);

        //To -> select ICN
        WebElement toBtn = driver.findElement(By.xpath("//button[contains(@id,'destinationBtn')]"));
        toBtn.click();
        helper.waitUntilLocatorExist(inputLocator);
        driver.findElement(inputLocator).sendKeys("ICN", Keys.ENTER);


        Thread.sleep(5000);
        driver.quit();
    }
}
