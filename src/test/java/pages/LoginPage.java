package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By usernamefield = By.xpath("//input[@id='user-name']");
    By passwordfield = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//input[@id='login-button']");
    By errormessage = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    public LoginPage(WebDriver driver){
       super(driver);
    }

    public void enterUsername(String username){
        driver.findElement(usernamefield).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordfield).sendKeys(password);
    }

    public void clickLoginBtn(){
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(loginBtn).click();
    }

    public boolean getErrorMessage(){
      return driver.findElement(errormessage).isDisplayed();
    }

    }


