package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCart extends BasePage{

    public YourCart(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//*[@id='item_4_title_link']/div")
    private WebElement productName;

    @FindBy(id="checkout")
    private WebElement checkoutBtn;

    public WebElement getProductName(){
        return productName;
    }

    public WebElement getCheckoutBtn() {
        return checkoutBtn;
    }
}
