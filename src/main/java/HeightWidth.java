import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Task - Take a partial screenshot of the WebElement
 *
 * Step 1: Go to https://rahulshettyacademy.com/angularpractice/
 * Step 2: Get height and width of the WebElement
 */
public class HeightWidth {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameInput = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
        int nameHeight = nameInput.getRect().getDimension().getHeight();
        int nameWidth = nameInput.getRect().getDimension().getWidth();

        System.out.println("Height is: " + nameHeight);
        System.out.println("Width is: " + nameWidth);

        driver.quit();
    }
}
