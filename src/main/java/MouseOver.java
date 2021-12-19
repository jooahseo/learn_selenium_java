import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 1. Go to amazon.com
 * 2. mouse over to the sign in
 * 3. click Account
 * 4. start search the product with Capital Letters only
 */
public class MouseOver {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        //mouse over to Hello, Sign in
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']"))).build().perform();
        //Click Account
        WebElement account = driver.findElement(By.xpath("//span[(@class='nav-text') and (text()='Account')]"));
        account.click();

        //move to search bar and search the product with capital letter
        String product = "germinated brown rice organic";
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        action.moveToElement(searchInput).click().keyDown(Keys.SHIFT).sendKeys(product).build().perform();
        //click search button
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        action.moveToElement(searchButton).click().build().perform();
        Thread.sleep(3000);
        driver.quit();
    }
}
