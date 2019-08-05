package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends AbstractPage{
    By emailInput = By.id("signInEmail");

    public SignInPage enterEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        return this;
    }

    public SignInPage enterPassword (String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInPassword"))).sendKeys(password);

        return this;
    }

    public  HomePage clickSignInButtom (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'form__sign-in')]"))).click();
        return new HomePage();
    }
    public boolean checkErroeMasseg(){
        boolean isDisplay =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'error-message ng-binding')]"))).isDisplayed();
        return isDisplay;
    }
}
