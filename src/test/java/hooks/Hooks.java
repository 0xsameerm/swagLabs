package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
