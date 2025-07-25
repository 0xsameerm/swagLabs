package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class HomePagePF extends BasePage{

    @FindBy(xpath ="//button[@id='react-burger-menu-btn']")
    private WebElement hamburgerIcon;

    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    private WebElement logoutBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpack_addtocartbtn;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a/span")
    private WebElement cartNumber;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private WebElement cartBtn;

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

    public WebElement getCartNumber(){
        return cartNumber;
    }

    public WebElement getCartBtn(){
        return cartBtn;
    }
}
