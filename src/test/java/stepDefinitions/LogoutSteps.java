package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePagePF;
import pages.LoginPage;

import java.time.Duration;

public class LogoutSteps {
    WebDriver driver;
    LoginPage lp;
    HomePagePF hp;

    public LogoutSteps(){
        this.driver = Hooks.getDriver();
        lp=new LoginPage(driver);
        hp=new HomePagePF(driver);
    }

    @When("user clicks on Hamburger icon")
    public void userClicksOnHamburgerIcon() {
        hp.getHamburgerIcon().click();
    }

    @And("clicks on logout button")
    public void clicksOnLogoutButton() throws InterruptedException {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hp.getLogoutBtn());
        }catch(ElementNotInteractableException e){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(hp.getLogoutBtn()));
        }
    }

    @Then("user is navigated to the login page")
    public void userIsNavigatedToTheLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
        Assert.assertEquals(lp.getPageURL(),"https://www.saucedemo.com/");
    }

}
