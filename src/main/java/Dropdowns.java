import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import sun.jvm.hotspot.utilities.Assert;

/**
 * 1. select dropdown on Amazon
 * 2. search for the product
 * 3. click the first result product
 * 4. check if product title is matching search text (check by word -> all words are included?)
 * 5. if yes, print the price
 * 6. if no, print "no matching product"
 */
public class Dropdowns {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();

        String product= "poland spring energy water 12";
        String[] productWords = product.split(" ");
        String price;

        driver.get("https://www.amazon.com/");

        WebElement dropdown = driver.findElement(By.xpath("//select[contains(@class, 'nav-search-dropdown')]"));
        WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement submitButton = driver.findElement(By.id("nav-search-submit-button"));

        Select amazonDropdown = new Select(dropdown);
        amazonDropdown.selectByValue("search-alias=amazonfresh");
        searchbar.sendKeys(product);
        submitButton.click();

        driver.findElement(By.xpath("//div[@data-index='0']")).click();
        if(allWordsIncludedInTitle(driver, productWords)){
            price = driver.findElement(By.id("priceblock_ourprice")).getText();
            System.out.println(product + "'s price is " +price);
        }else{
            System.out.println("no matching product");
        }
        Thread.sleep(5000);
        driver.close();
    }

    private static boolean allWordsIncludedInTitle(WebDriver driver, String[] words){
        String productTitle = driver.findElement(By.id("productTitle")).getText().toLowerCase();

        for(String word: words){
            if(!productTitle.contains(word.toLowerCase())){
                return false;
            }
        }
        return true;
    }
}
