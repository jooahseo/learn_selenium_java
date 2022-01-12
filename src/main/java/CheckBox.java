import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //check and uncheck the first check box
        WebElement firstCheckBox = driver.findElement(By.id("checkBoxOption1"));
        firstCheckBox.click();
        if(firstCheckBox.isSelected()){
            System.out.println("first checkbox is selected!");
        }
        Thread.sleep(3000);
        firstCheckBox.click();
        if(!firstCheckBox.isSelected()){
            System.out.println("first checkbox is un-selected");
        }
        Thread.sleep(3000);

        //get counts of all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int checkboxCount = checkboxes.size();
        System.out.println("Total counts of checkbox: " + checkboxCount);

        driver.quit();
    }
}
