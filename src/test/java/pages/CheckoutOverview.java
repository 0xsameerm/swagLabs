package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview extends BasePage {

    public CheckoutOverview(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="finish")
    private WebElement finishBtn;

    public WebElement getFinishBtn() {
        return finishBtn;
    }
}
