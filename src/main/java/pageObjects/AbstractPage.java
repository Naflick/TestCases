package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    public static WebDriverWait wait;// = new WebDriverWait(DriverFactory.getDriver(),20);


    public AbstractPage(){
        DriverFactory.initDriver("Chrome");
        wait = new WebDriverWait(DriverFactory.getDriver(),20);
    }

    public void proceedToPage(String url){
        DriverFactory.getDriver().get(url);
    }
    protected WebElement getElement(By locator){
        WebElement webElement =wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return  webElement;
    }

}
