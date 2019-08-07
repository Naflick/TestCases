package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends AbstractPage{
    private By emailInput = By.id("signInEmail");
    private By passwordInput = By.id("signInPassword");
    private By signInButtom = By.xpath("//*[contains(@class,'form__sign-in')]");
    private By erroeMasseg = By.xpath("//*[contains(@class,'error-message ng-binding')]");


    public SignInPage enterEmail(String email){
        AbstractPage.getElement(emailInput).sendKeys(email);
        return this;
    }

    public SignInPage enterPassword (String password){
        AbstractPage.getElement(passwordInput).sendKeys(password);
        return this;
    }

    public  HomePage clickSignInButtom (){
        AbstractPage.getElement(signInButtom).click();
        return new HomePage();
    }
    public boolean checkErroeMasseg(){
        return AbstractPage.getElement(erroeMasseg).isDisplayed();
    }
}
