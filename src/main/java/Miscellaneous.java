import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Miscellaneous {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        //maximize the window
        driver.manage().window().maximize();

        //delete cookies
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("sessionKey");

        //Taking screenshot
        driver.get("https://github.com/jooahseo");
        //get the file output as a file format, so we can view
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //src has the screenshot -> copy file to the directory
        FileUtils.copyFile(src, new File("/Users/jooahseo/work/screenshotBySelenium.png"));

        //Handle broken links => page throws an error when it's opened -> but can't open all the links (time-consuming)
        //How? Java methods to call URLs and gets the status code
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
        SoftAssert softAssert = new SoftAssert();

        for(WebElement link: links){
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println("Response code for " + link.getText() + " -> " + responseCode);

            //script stops once broken link is found -> cannot check rest of the links.
            //reports a failure -> but execution has to continue
            if(responseCode > 400){
                Assert.fail("Link is broken for " + link.getText());
            }

            // To complete execution -> can use Soft Assertion
            softAssert.assertTrue(responseCode < 400, "Link is broken for " + link.getText());
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
