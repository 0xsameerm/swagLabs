package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePagePF;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver;
    LoginPage lp;
    HomePagePF hp;

    public LoginSteps(){
        this.driver = Hooks.getDriver();
        lp=new LoginPage(driver);
        hp=new HomePagePF(driver);
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        Assert.assertTrue(lp.getErrorMessage());
    }

}
