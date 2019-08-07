import driver.DriverFactory;
import org.junit.Test;
import pageObjects.businessObjects.HomeBO;

public class SignInTest {

    @Test
    public void sandInProcess()throws Exception{
        HomeBO homeBO = new HomeBO();
        try {
            homeBO.proceedToHomePage();
            homeBO.clickSignInButtomBO();
            homeBO.loginBO("ivanhorintest@gmail.com", "ivanhorintestPassword");
            homeBO.checkUserInfo();

        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            DriverFactory.quitDriver();
        }
    }
}
