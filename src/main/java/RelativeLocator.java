import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocator {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();

        /**
         * Task 1: Get the label of name box 'above' name input using Relative locator
         */
        System.out.println("-----------------Task 1-----------------");
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameInput = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
        WebElement nameLabel = driver.findElement(with(By.tagName("label")).above(nameInput));

        System.out.println("Label of the name box is: " + nameLabel.getText());

        /**
         * Task 2: Get the id of the input box 'below' Email label
         */
        System.out.println("-----------------Task 2-----------------");
        WebElement emailLabel = driver.findElement(By.xpath("//label[normalize-space()='Email']"));
        WebElement nameOfInput = driver.findElement(with(By.tagName("input")).below(emailLabel));

        System.out.println("Id of the input below Email label is: " + nameOfInput.getAttribute("id"));


        /**
         * Task 3: Click the box that on the 'left' side of Student label
         */
        System.out.println("-----------------Task 2-----------------");
        WebElement studentLabel = driver.findElement(By.xpath("//label[normalize-space()='Student']"));
        WebElement leftButton = driver.findElement(with(By.tagName("input")).toLeftOf(studentLabel));

        leftButton.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
