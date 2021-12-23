import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * 1. Go to https://jqueryui.com/droppable/
 * 2. Switch to Frame
 * 3. Drag and drop the element
 * 4. Switch to Default content
 * 5. Click other element
 */
public class DragAndDropInFrame {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        //in this way cannot locate the draggable because it's in the frame
        //So first, get frame and switch to frame where draggable resides
        //WebElement draggable = driver.findElement(By.id("draggable"));
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Total frame count is: "+ frames.size());

        //1st way: driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        //2nd way: driver.switchTo().frame(frames.get(0));
        //3rd way
        driver.switchTo().frame(0);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,target).build().perform();

        //Get out from the frame
        driver.switchTo().defaultContent();

        WebElement acceptButton = driver.findElement(By.xpath("//a[text()='Accept']"));
        acceptButton.click();

        Thread.sleep(3000);
        driver.quit();
    }

}
