import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DriverScope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // get all the links in the page
        List<WebElement> allAnchorTag = driver.findElements(By.tagName("a"));
        System.out.println("Total anchor tags in the page is: " + allAnchorTag.size());

        // get all the links in the footer by limiting the scope
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerAnchorTag = footer.findElements(By.tagName("a"));
        System.out.println("Total anchor tags in the footer: " + footerAnchorTag.size());

        // get all the links in the first column of the footer
        WebElement firstColumnFooter = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> firstColumnATag = firstColumnFooter.findElements(By.tagName("a"));
        System.out.println("Total links in the first column of the footer is: " + firstColumnATag.size());

        // click each link in the first column and open in a new tab
        for(int i=0; i< firstColumnATag.size(); i++){
            String openLinkOnTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
            firstColumnFooter.findElements(By.tagName("a")).get(i).sendKeys(openLinkOnTab);
        }

        //move to each tab -> get the title
        Thread.sleep(5000);

        Set<String> windows = driver.getWindowHandles();

        Iterator<String> window = windows.iterator();
        while(window.hasNext()){
            driver.switchTo().window(window.next());
            System.out.println(driver.getTitle() +" page is opened");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
