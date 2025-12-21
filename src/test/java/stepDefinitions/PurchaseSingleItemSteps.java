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


public class PurchaseSingleItemSteps {
    WebDriver driver;
    LoginPage lp;
    HomePagePF hp;
    YourCart yc;
    CheckoutYourInformation cyi;
    CheckoutOverview co;
    CheckoutComplete cc;

    public PurchaseSingleItemSteps(){
        this.driver = Hooks.getDriver();
        lp=new LoginPage(driver);
        hp=new HomePagePF(driver);
        yc=new YourCart(driver);
        cyi=new CheckoutYourInformation(driver);
        co=new CheckoutOverview(driver);
        cc=new CheckoutComplete(driver);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf((WebElement) hp.getCartNumber()));
        Assert.assertTrue(((WebElement) hp.getCartNumber()).getText().contains(cartnumber));
    }

    @When("user clicks on cart icon on top right of the page")
    public void userClicksOnCartIconOnTopRightOfThePage() {
        hp.getCartBtn().click();
    }

    @Then("the user is redirected to the Your Cart page")
    public void theUserIsRedirectedToTheYourCartPage() {
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

