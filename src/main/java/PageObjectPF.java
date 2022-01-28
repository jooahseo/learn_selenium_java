import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page Object Model using PageFactory
public class PageObjectPF {

    WebDriver driver;
    public PageObjectPF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="search")
    WebElement search;

    @FindBy(xpath="//input[@type='id']")
    WebElement id;

    public WebElement getSearch(){
        return search;
    }

    public WebElement getId(){
        return id;
    }
}
