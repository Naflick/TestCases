package pageObjects;

import org.openqa.selenium.By;

public class HomePage extends  AbstractPage{

    private By signInButtom = By.xpath("//*[contains(@class,'signin')]/span");
    private By trainingButtom = By.xpath("//*[contains(@class,'links-row')]//*[contains(@class,'topNavItem training')]");
    private By newsButtom = By.xpath("//*[contains(@class,'links-row')]//*[contains(@class,'topNavItem news')]");
    private By userInfo = By.xpath("//*[contains(@class,'user-info__name')]");

    public SignInPage clickSignInButtom(){
        AbstractPage.getElement(signInButtom).click();
        return new SignInPage();
    }
    public TrainingPage clickTrainingButtom(){
        AbstractPage.getElement(trainingButtom).click();
        return new TrainingPage();
    }
    public NewsPage clickNewsButtom(){
        AbstractPage.getElement(newsButtom).click();
        return new NewsPage();
    }
    public boolean checkUserInfo(){
        return AbstractPage.getElement(userInfo).isDisplayed();
    }

}
