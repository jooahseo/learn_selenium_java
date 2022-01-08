import Helper.ScreenController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HotelBooking {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        ScreenController controller = new ScreenController(driver);

        driver.manage().window().maximize();
        driver.get("https://www.sojospaclub.com/hotel/");

        WebElement bookNow = driver.findElement(By.xpath("//a[(@class='rates--single__link') and (text()='Book Now')]"));
        bookNow.click();
        //bookNow will open new tab -> get to the second tab
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterators = windows.iterator();
        String firstTab = iterators.next();
        String secondTab = iterators.next();

        driver.switchTo().window(secondTab);
        Thread.sleep(3000);
        String startDate = "03/01/2022";
        String endDate = "03/02/2022";

        WebElement checkInDate = driver.findElement(By.xpath("//input[@name='search_start_date']"));
        WebElement checkOutDate = driver.findElement(By.id("end_date_not_mobile"));
        WebElement searchButton = driver.findElement(By.xpath("//button[normalize-space()='Search']"));

        for(int i=0; i<startDate.length(); i++){
            checkInDate.sendKeys(Keys.BACK_SPACE);
        }
        checkInDate.sendKeys(startDate);
        for(int i=0; i<startDate.length(); i++){
            checkOutDate.sendKeys(Keys.BACK_SPACE);
        }
        checkOutDate.sendKeys(endDate);
        searchButton.click();
        List<WebElement> availableRooms = driver.findElements(By.xpath("//div[@class='availability_list']/div"));

        if(availableRooms.size() > 0){
            System.out.println("Rooms are available!");
        }else{
            System.out.println("There is no room");
        }
        Thread.sleep(5000);
        driver.quit();
    }

    public static void handlePopup(WebDriver driver) throws InterruptedException {
        ScreenController controller = new ScreenController(driver);
        if(controller.elementExist(By.id("pum_popup_title_490784"))){
            WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Agree')]"));
            button.click();
            controller.sleep(2000);
        }
    }
}
