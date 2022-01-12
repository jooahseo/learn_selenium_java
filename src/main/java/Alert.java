import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) throws InterruptedException {
        String text = "Jooah";
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        //alert type 1: "ok" button only
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        //alert type 2: "ok", "cancel" options
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(3000);

        //dismiss -> click negative button, in this case, "cancel"
        //but if there's only "ok" it will click "ok" button
        driver.switchTo().alert().dismiss();
        driver.quit();
    }
}
