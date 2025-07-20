package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }
    public String getPageTitle() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }



}
