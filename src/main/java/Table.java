import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Table {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();

        /**
         * Task 1:
         * if there are multiple tables in the page
         * get parent element -> and get child element
         */

        //get 4th column and calculate sum of the numbers
        System.out.println("-----------------Task 1-----------------");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for(int i=0; i<values.size(); i++){
            sum += Integer.parseInt(values.get(i).getText());
        }
        System.out.println("Sum of all the values from the 4th column of table is: " + sum);


        /**
         * Task 2:
         * click sort on the table and check if table's data has been sorted
         */
        System.out.println("-----------------Task 2-----------------");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click sorting button
        driver.findElement(By.xpath("//tr/th[1]/span[2]")).click();

        //get all (visible) items from the table
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> originalList = items.stream().map(item -> item.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(originalList.equals(sortedList));

    }

}
