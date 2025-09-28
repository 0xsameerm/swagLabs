package stepDefinitions;

import hooks.Hooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pages.*;

import java.time.Duration;


public class StepDefinition {
    WebDriver driver;
    LoginPage lp;
    HomePagePF hp;
    YourCart yc;
    CheckoutYourInformation cyi;
    CheckoutOverview co;
    CheckoutComplete cc;

    public StepDefinition(){
        this.driver = Hooks.getDriver();
        lp=new LoginPage(driver);
        hp=new HomePagePF(driver);
        yc=new YourCart(driver);
        cyi=new CheckoutYourInformation(driver);
        co=new CheckoutOverview(driver);
        cc=new CheckoutComplete(driver);
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
    @When("clicks on login button")
    public void clicks_on_login_button() {
    lp.clickLoginBtn();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
         Assert.assertEquals(hp.getPageTitle(),"Swag Labs");
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

    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        Assert.assertEquals(hp.getPageTitle(),"Swag Labs");
    }
    
    @When("user clicks on Add to cart button of Sauce Labs Backpack")
    public void userClicksOnAddToCartButtonOfSauceLabsBackpack() {
        hp.getBackpackCartbtn().click();
    }

    @Then("{string} is displayed in the cart")
    public void isDisplayedInTheCart(String cartnumber){
        Assert.assertTrue(hp.getCartNumber().getText().contains(cartnumber));
    }

    @When("user clicks on cart icon on top right of the page")
    public void userClicksOnCartIconOnTopRightOfThePage() {
        hp.getCartBtn().click();
    }

    @Then("the user is redirected to the Your Cart page")
    public void theUserIsRedirectedToTheYourCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        Assert.assertEquals(yc.getPageHeading(),"Your Cart");
    }

    @And("the selected product details is displayed")
    public void theSelectedProductDetailsIsDisplayed() {
        Assert.assertTrue(yc.getProductName().getText().contains("Sauce Labs Backpack"));
    }

    @When("user clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        yc.getCheckoutBtn().click();
    }

    @Then("user is navigated to the Checkout: Your Information page")
    public void userIsNavigatedToTheCheckoutYourInformationPage() {
        Assert.assertEquals(cyi.getPageHeading(),"Checkout: Your Information");
    }

    @When("user Enters First Name {string} , Last Name {string} and Postal code {string}")
    public void userEntersFirstNameLastNameAndPostalCode(String fName, String lName, String pCode) {
        cyi.getFirstName().sendKeys(fName);
        cyi.getLastName().sendKeys(lName);
        cyi.getPostalCode().sendKeys(pCode);
    }

    @And("click on Continue button")
    public void clickOnContinueButton() {
        cyi.getContinueBtn().click();
    }

    @Then("user is navigated to the Checkout: Overview page")
    public void userIsNavigatedToTheCheckoutOverviewPage() {
        Assert.assertEquals(yc.getPageHeading(),"Checkout: Overview");
    }

    @When("user clicks on Finish button")
    public void userClicksOnFinishButton() {
        co.getFinishBtn().click();
    }

    @Then("user is navigated to the Checkout: Complete! page")
    public void userIsNavigatedToTheCheckoutCompletePage() {
        Assert.assertEquals(cc.getPageHeading(),"Checkout: Complete!");
    }
}

