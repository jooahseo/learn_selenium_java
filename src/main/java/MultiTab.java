import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

/**
 * 1. Go to amazon.com
 * 2. click Careers
 * 3. click LinkedIn link - will new open a tab with LinkedIn page
 * 4. navigate first tab and second tab
 */
public class MultiTab {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        // Go to career page
        WebElement careers = driver.findElement(By.xpath("//a[(@class='nav_a') and (text()='Careers')]"));
        careers.click();
        // click linked in link from career page
        WebElement linkedIn = driver.findElement(By.xpath("//a[@id='linkedin-link-footer']"));
        linkedIn.click();

        //get windows
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterators = windows.iterator();
        String firstTab = iterators.next();
        String secondTab = iterators.next();

        //move back and forth between tabs
        driver.switchTo().window(firstTab);
        Thread.sleep(2000);
        driver.switchTo().window(secondTab);

        Thread.sleep(3000);
        driver.quit();
    }
}
