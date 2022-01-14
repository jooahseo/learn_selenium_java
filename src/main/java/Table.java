import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Table {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /**
         * if there are multiple tables in the page
         * get parent element -> and get child element
         */

        //get 4th column and calculate sum of the numbers
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for(int i=0; i<values.size(); i++){
            sum += Integer.parseInt(values.get(i).getText());
        }
        System.out.println("Sum of all the values from the 4th column of table is: " + sum);

        driver.quit();
    }
}
