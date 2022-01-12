import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class Ecommerce {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        String[] shoppingList = {"Brocolli","Tomato", "Mushroom", "Walnuts"};

        addProductIntoCart(shoppingList, driver);
        proceedCart(driver);
        chooseCountryAndAgree(driver);
        checkOrderComplete(driver);

        Thread.sleep(5000);

        driver.quit();
    }

    /**
     * 1. Get index of each product from the list of the products in the page
     * 2. Once matching product is found, click button to add to cart
     * @param shoppingList
     */
    public static void addProductIntoCart(String[] shoppingList, WebDriver driver) throws InterruptedException {
        waitUntilProductPageIsLoaded(driver);

        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

        for(int i=0; i< products.size(); i++){
            String productName = products.get(i).getText();
            boolean contains = Arrays.stream(shoppingList).anyMatch(productName::contains);
            int count = 0;
            if(contains){
                buttons.get(i).click();
                count ++;
            }
            if(count == shoppingList.length) break;
        }
    }

    public static void proceedCart(WebDriver driver) throws InterruptedException {
        WebElement cart = driver.findElement(By.xpath("//img[@alt='Cart']"));
        cart.click();

        WebElement proceed = driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']"));
        proceed.click();

        waitUntilCartPageIsLoaded(driver);
        WebElement placeOrder = driver.findElement(By.xpath("//button[normalize-space()='Place Order']"));
        placeOrder.click();
    }

    public static void chooseCountryAndAgree(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select"));
        Select countryDropdown = new Select(dropDown);
        countryDropdown.selectByValue("United States");

        WebElement agreeTerms = driver.findElement(By.xpath("//input[@type='checkbox']"));
        agreeTerms.click();

        WebElement proceedBtn = driver.findElement(By.xpath("//button[normalize-space()='Proceed']"));
        proceedBtn.click();
    }

    public static void checkOrderComplete(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement thankYouMessage = driver.findElement(By.xpath("//span[contains(text(),'Thank you, your order has been placed successfully')]"));
        Assert.assertTrue(thankYouMessage.isDisplayed());
        System.out.println("order has been placed!");
    }

    public static void waitUntilProductPageIsLoaded(WebDriver driver) throws InterruptedException {
        WebElement product;
        for(int i=0; i<3; i++){
            try{
                product = driver.findElement(By.xpath("//div[@class='product']"));
                if(product.isDisplayed()) break;
            }catch(Exception e){
                System.out.println("page is loading...");
                Thread.sleep(2000);
            }
        }
    }

    public static void waitUntilCartPageIsLoaded(WebDriver driver) throws InterruptedException {
        WebElement placeOrder;
        for(int i=0; i<3; i++){
            try{
                placeOrder = driver.findElement(By.xpath("//button[normalize-space()='Place Order']"));
                if(placeOrder.isDisplayed()) break;
            }catch(Exception e){
                System.out.println("page is loading...");
                Thread.sleep(2000);
            }
        }
    }
}
