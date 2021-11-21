import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Launch the website using webdriver and close.
 */
public class Introduction {
    public static void main(String[] args) {
        //windows
        //System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver_win32\\chromedriver.exe");
        //mac
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        driver.close();
    }
}
