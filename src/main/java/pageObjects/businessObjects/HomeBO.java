package pageObjects.businessObjects;

import org.junit.Assert;
import pageObjects.*;

public class HomeBO {
    private HomePage homePage;
    private AbstractPage abstractPage;
    private SignInBO signInBO;
    public HomeBO(){
        homePage = new HomePage();
        abstractPage = new AbstractPage();
        signInBO = new SignInBO();
    }

    public HomePage proceedToHomePage(){
        abstractPage.proceedToPage();
        return new HomePage();
    }
    public SignInPage clickSignInButtomBO(){
        homePage.clickSignInButtom();
        return new SignInPage();
    }
    public HomePage loginBO(String email,String password){
        signInBO.login(email,password);
        return new HomePage();
    }
    public void checkUserInfo(){
        Assert.assertTrue(" ", homePage.checkUserInfo());
    }
    public NewsPage clickNewsPageButtom(){
        homePage.clickNewsButtom();
        return new NewsPage();
    }
    public TrainingPage clickTrainingPageButtom(){
        homePage.clickTrainingButtom();
        return new TrainingPage();
    }





}
