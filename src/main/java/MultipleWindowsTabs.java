import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

/**
 * Task - navigating to different tab and get the information
 *
 * Step 1: Open https://rahulshettyacademy.com/angularpractice/
 * Step 2: Open https://courses.rahulshettyacademy.com/courses in a new tab
 * Step 3: Get the first course name
 * Step 4: Go to https://rahulshettyacademy.com/angularpractice/
 * Step 5: Write that course name in name input box
 */

public class MultipleWindowsTabs {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //open a new blank tab - but no knowledge on that new tab
        driver.switchTo().newWindow(WindowType.TAB);

        //get the window's id for each window
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> windows = handles.iterator();
        String firstWindowId = windows.next();
        String secondWindowId = windows.next();

        //navigate to 2nd window tab
        driver.switchTo().window(secondWindowId);
        driver.get("https://courses.rahulshettyacademy.com/courses");

        //get name of the first course name
        String firstCourse = driver.findElement(By.xpath("(//div[@class='course-listing-title'])[1]")).getText();

        //navigate back to 1st window tab
        driver.switchTo().window(firstWindowId);
        System.out.println("write course name into name input: " + firstCourse);
        driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys(firstCourse);

        Thread.sleep(3000);
        driver.quit();
    }
}
