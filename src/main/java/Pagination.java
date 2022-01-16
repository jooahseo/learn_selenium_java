import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();

        /**
         * Task 1:
         * Go to next page until product is found
         */
        System.out.println("-----------------Task 1-----------------");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String product = "Apple";

        //get all (visible) items from the table
        List<String> prices;
        do{
            List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
            prices = items.stream().filter(i -> i.getText().equals(product))
                    .map(i -> getPrice(i)).collect(Collectors.toList());

            WebElement next = driver.findElement(By.xpath("//a[@aria-label='Next']"));
            if(next.getAttribute("aria-disabled").equals("true")) break;
            next.click();
        } while(prices.size() == 0);

        if(prices.size() == 0){
            System.out.println("price is not found for " + product);
        }else{
            prices.stream().forEach(price -> System.out.println("price of " + product + " is: " + price));
        }

        Thread.sleep(3000);
        driver.quit();
    }

    public static String getPrice(WebElement item){
        return item.findElement(By.xpath("./following-sibling::td")).getText();
    }
}