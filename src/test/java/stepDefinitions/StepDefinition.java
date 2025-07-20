package stepDefinitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePagePF;
import pages.LoginPage;



public class StepDefinition {
    WebDriver driver;

    LoginPage lp;
    HomePagePF hp;
    BasePage bp;

    @Before
    public void openBrowser(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Given("user is on the swag labs login page")
    public void user_is_on_the_swag_labs_login_page() {
        driver.get("https://www.saucedemo.com/");
        lp=new LoginPage(driver);
        hp=new HomePagePF(driver);
        bp=new BasePage(driver);
    }
    @When("user enters the username {string}")
    public void user_enters_the_username(String username) {
    lp.enterUsername(username);
    }
    @When("user enters the password {string}")
    public void user_enters_the_password(String password) {
    lp.enterPassword(password);
    }
    @When("clicks on login button")
    public void clicks_on_login_button() {
    lp.clickLoginBtn();
    }
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
         Assert.assertEquals(bp.getPageTitle(),"Swag Labs");
    }


    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
    Assert.assertTrue(lp.getErrorMessage());
    }

    @When("user enters the {string} and {string}")
    public void userEntersTheUsernameAndPassword(String username,String password) {
        lp.enterUsername(username);
        lp.enterPassword(password);
    }

    @When("user clicks on Hamburger icon")
    public void userClicksOnHamburgerIcon() {
        hp.getHamburgerIcon().click();
    }

    @And("clicks on logout button")
    public void clicksOnLogoutButton() throws InterruptedException {
     hp.getLogoutBtn().click();
    }

    @Then("user is navigated to the login page")
    public void userIsNavigatedToTheLoginPage() {
        Assert.assertEquals(bp.getPageURL(),"https://www.saucedemo.com/");
    }

    @After
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}

