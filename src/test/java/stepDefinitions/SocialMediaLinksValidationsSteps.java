package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePagePF;

import javax.swing.*;

public class SocialMediaLinksValidationsSteps {

    WebDriver driver;
    HomePagePF hp;
    private String parentWindow;

    public SocialMediaLinksValidationsSteps(){
        this.driver = Hooks.getDriver();
        hp = new HomePagePF(driver);
    }

    @And("clicks on twiiter logo")
    public void clicksOnTwiiterLogo() {
        parentWindow = driver.getWindowHandle();
        hp.getTwitterLogo().click();
    }


    @Then("user is navigated to twiiter profile page in new tab")
    public void userIsNavigatedToTwiiterProfilePageInNewTab() {

         for(String window : driver.getWindowHandles()){
             if(!window.equals(parentWindow)){
                 driver.switchTo().window(window);
                 break;
             }
         }
         String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://x.com/saucelabs");
    }

    @When("user closes the tab then user is navigated to the home page")
    public void userClosesTheTabThenUserIsNavigatedToTheHomePage() {
        driver.close();
        driver.switchTo().window(parentWindow);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
    }


    @Given("user clicks on facebook logo")
    public void userClicksOnFacebookLogo() {
        hp.getFacebookLogo().click();
    }


    @Then("user is navigated to facebook profile page in new tab")
    public void userIsNavigatedToFacebookProfilePageInNewTab() {

        for(String window : driver.getWindowHandles()){
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.facebook.com/saucelabs");
    }

    @Given("user clicks on Linkedin logo")
    public void userClicksOnLinkedinLogo() {
        hp.getLinkedInLogo().click();
    }


    @Then("user is navigated to Linkedin profile page in new tab")
    public void userIsNavigatedToLinkedinProfilePageInNewTab() {

        for(String window : driver.getWindowHandles()){
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.linkedin.com/company/sauce-labs/");
    }
}
