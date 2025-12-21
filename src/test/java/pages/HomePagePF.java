package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePagePF extends BasePage{

    @FindBy(xpath ="//button[@id='react-burger-menu-btn']")
    private WebElement hamburgerIcon;

    @FindBy(id ="logout_sidebar_link")
    private WebElement logoutBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpack_addtocartbtn;

    private By cartNumber = By.xpath("//*[@class='shopping_cart_badge']");

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private WebElement cartBtn;

    private By addtocartBtns = By.xpath("//*[text() = 'Add to cart']");

    private By removeBtns = By.xpath("//*[text()='Remove']");

    public HomePagePF(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getHamburgerIcon() {
        return hamburgerIcon;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }


    public WebElement getBackpackCartbtn(){
        return backpack_addtocartbtn;
    }

    public By getCartNumber(){
        return cartNumber;
    }

    public WebElement getCartBtn(){
        return cartBtn;
    }

    public int getItemCount(){
            List<WebElement> badge = driver.findElements(cartNumber);

            if (badge.isEmpty()) {
                return 0;
            }

            return Integer.parseInt(badge.getFirst().getText());
    }

    public void addItemsToCart(int count){
        for(int i=0;i<count;i++){
            driver.findElements(addtocartBtns).getFirst().click();
        }
    }

    public void removeItemsFromCart(int count) {
        for (int i=0; i<count; i++) {
            driver.findElements(removeBtns).getFirst().click();
        }
    }
}
