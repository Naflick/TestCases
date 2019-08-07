package pageObjects.businessObjects;

import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInBO {
    private SignInPage signInPage;

    public SignInBO(){signInPage = new SignInPage();}

    public HomeBO login(String email, String password){
        signInPage
                .enterEmail(email)
                .enterPassword(password)
                .clickSignInButtom();
        return new HomeBO();
    }

    public void verefiErroeMassegIsDisplay(){
        Assert.assertTrue(" ", signInPage.checkErroeMasseg());
    }
}
