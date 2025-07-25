package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

   protected WebDriver driver;
    By Heading = By.className("title");

    public BasePage(WebDriver driver){
        this.driver =driver;
    }

    public  String getPageTitle() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public String getPageHeading(){
       return driver.findElement(Heading).getText();
    }


}
