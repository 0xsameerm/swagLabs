package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePagePF;

public class CartValidationsSteps {
    WebDriver driver;
    HomePagePF hp;

    private int itemCount;

    public CartValidationsSteps(){
        this.driver = Hooks.getDriver();
        hp = new HomePagePF(driver);
    }

    @And("adds {int} items to cart")
    public void addsCountItemsToCart(int count) {
        itemCount = count;
        hp.addItemsToCart(count);
    }

    @Then("cart badge should display the number of items in the cart correctly")
    public void cartBadgeShouldDisplayTheNumberOfItemsInTheCartCorrectly() {
        Assert.assertEquals(hp.getItemCount(),itemCount);
        //System.out.println(hp.getItemCount());
    }


    @Then("remove {int} items from cart")
    public void removeRemovecountItemsFromCart(int count) {

                hp.removeItemsFromCart(count);
                itemCount = itemCount - count;
                Assert.assertEquals(hp.getItemCount(), itemCount);

        System.out.println(hp.getItemCount());
    }
}
