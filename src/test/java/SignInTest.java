import driver.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import pageObjects.AbstractPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInTest {

    @Test
    public void sandInProcess()throws Exception{
        HomePage home = new HomePage();
        SignInPage signin = new SignInPage();
        AbstractPage baseas = new AbstractPage();
        try {

            baseas.proceedToPage("https://training.by/#/Home");
            home.clickSignInButtom();
            signin.enterEmail("ivanhorintest@gmail.com");
            signin.enterPassword("ivanhorintestPassword");
            signin.clickSignInButtom();
            Assert.assertTrue(" ", home.checkUserInfo());


        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            DriverFactory.quitDriver();
        }
    }
}
