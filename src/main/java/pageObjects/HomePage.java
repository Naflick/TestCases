package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends  AbstractPage{

    public SignInPage clickSignInButtom(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'signin')]/span"))).click();
        return new SignInPage();
    }
    public TrainingPage clickTrainingButtom(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'links-row')]//*[contains(@class,'topNavItem training')]"))).click();
        return new TrainingPage();
    }
    public HomePage clickNewsButtom(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'links-row')]//*[contains(@class,'topNavItem news')]"))).click();
        return this;
    }
    public boolean checkUserInfo(){
        boolean isDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'user-info__name')]"))).isDisplayed();
        return isDisplay;
    }

}
