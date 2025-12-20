package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePagePF;
import pages.LoginPage;

public class CommonSteps {
    WebDriver driver;
    LoginPage lp;
    HomePagePF hp;

    public CommonSteps(){
        this.driver = Hooks.getDriver();
        lp=new LoginPage(driver);
        hp=new HomePagePF(driver);
    }

    @Given("user is on the swag labs login page")
    public void user_is_on_the_swag_labs_login_page() {
        driver.get("https://www.saucedemo.com/");
    }
    @When("user enters the username {string}")
    public void user_enters_the_username(String username) {
        lp.enterUsername(username);
    }
    @When("user enters the password {string}")
    public void user_enters_the_password(String password) {
        lp.enterPassword(password);
    }
    @When("user enters the {string} and {string}")
    public void userEntersTheUsernameAndPassword(String username,String password) {
        lp.enterUsername(username);
        lp.enterPassword(password);
    }
    @When("clicks on login button")
    public void clicks_on_login_button() {
        lp.clickLoginBtn();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        Assert.assertEquals(hp.getPageTitle(),"Swag Labs");
    }
}
