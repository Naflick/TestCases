package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    public static WebDriverWait wait;
    public static String url = "https://training.by/#/Home";

    public AbstractPage(){
        DriverFactory.initDriver("Chrome");
        wait = new WebDriverWait(DriverFactory.getDriver(),20);
    }

    public void proceedToPage(){
        DriverFactory.getDriver().get(url);
    }

    public static WebElement getElement(By locator){
        WebElement webElement =wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return  webElement;
    }

}
