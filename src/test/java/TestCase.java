import driver.DriverFactory;
import org.junit.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.NewsBO;
import pageObjects.businessObjects.SignInBO;
import pageObjects.businessObjects.TrainingBO;

public class TestCase {
    @Test
    public void verityUserIsSuccessfullyLogetIn()throws Exception{
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

    @Test
    public void verityUserIsNoSuccessfullyLogetIn() throws Exception {
        SignInBO signInBO = new SignInBO();
        HomeBO homeBO = new HomeBO();
        try {
            homeBO.proceedToHomePage();
            homeBO.clickSignInButtomBO();
            homeBO.loginBO("incorrect@gmail.com", "incorrectPassword");
            signInBO.verefiErroeMassegIsDisplay();

        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            DriverFactory.quitDriver();
        }
    }

    @Test
    public void verityTreaningSearchingSkills()throws Exception{
        HomeBO homeBO = new HomeBO();
        TrainingBO trainingBO = new TrainingBO();
        try {
            homeBO.proceedToHomePage();
            homeBO.clickSignInButtomBO();
            homeBO.loginBO("ivanhorintest@gmail.com", "ivanhorintestPassword");
            homeBO.checkUserInfo();
            homeBO.clickTrainingPageButtom();
            trainingBO.clickSkillsDropDownButtom();
            trainingBO.verefySkillsDropDownResult("java");
            trainingBO.verefySkillsDropDownResult("data");
            trainingBO.verefySkillsDropDownVoidResult("Paskal");

        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            DriverFactory.quitDriver();
        }
    }

    @Test
    public void verityNewsPageObject()throws Exception{
        HomeBO homeBO = new HomeBO();
        NewsBO newsBO = new NewsBO();
        try {
            homeBO.proceedToHomePage();
            homeBO.clickSignInButtomBO();
            homeBO.loginBO("ivanhorintest@gmail.com", "ivanhorintestPassword");
            homeBO.checkUserInfo();
            homeBO.clickNewsPageButtom();
            newsBO.verefiVideosButtomIsDisplay();
            newsBO.verefiSuccessStoriesButtomIsDisplay();
            newsBO.verefiMaterialssButtomIsDisplay();
            newsBO.verefiNewsButtomIsDisplay();


        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            DriverFactory.quitDriver();
        }
    }

    @Test
    public void verityTreaningSearchingLocations()throws Exception{
        HomeBO homeBO = new HomeBO();
        TrainingBO trainingBO = new TrainingBO();
        try {
            homeBO.proceedToHomePage();
            homeBO.clickSignInButtomBO();
            homeBO.loginBO("ivanhorintest@gmail.com", "ivanhorintestPassword");
            homeBO.checkUserInfo();
            homeBO.clickTrainingPageButtom();
            trainingBO.clickLocationDropDownButtom();
            trainingBO.verefyLocationDropDownResult("kyiv","ukraine");
            trainingBO.verefyLocationDropDownVoidResult("los Angeles");
        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            DriverFactory.quitDriver();
        }
    }

}

