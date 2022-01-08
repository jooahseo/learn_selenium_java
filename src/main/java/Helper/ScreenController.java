package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ScreenController {

    WebDriver driver;
    public ScreenController(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public boolean elementExist(By locator){
        return driver.findElements(locator).size() > 0;
    }

    public void sleep(long millisec) throws InterruptedException {
        Thread.sleep(millisec);
    }

}
