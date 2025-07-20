package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePF{
    WebDriver driver;

    @FindBy(xpath ="//button[@id='react-burger-menu-btn']")
    WebElement hamburgerIcon;

    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    WebElement logoutBtn;

    public HomePagePF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getHamburgerIcon() {
        return hamburgerIcon;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }



}
