import driver.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import pageObjects.AbstractPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.TrainingPage;

public class TestCase {
    @Test
    public void verityUserIsSuccessfullyLogetIn()throws Exception{
        HomePage home = new HomePage();
        SignInPage signin = new SignInPage();
        AbstractPage baseas = new AbstractPage();
        try {

            baseas.proceedToPage("https://training.by/#/Home");
            home
                    .clickSignInButtom();
            signin
                    .enterEmail("ivanhorintest@gmail.com")
                    .enterPassword("ivanhorintestPassword")
                    .clickSignInButtom();
            Assert.assertTrue(" ", home.checkUserInfo());


        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            DriverFactory.quitDriver();
        }
    }

    @Test
    public void verityUserIsNoSuccessfullyLogetIn()throws Exception{
        HomePage home = new HomePage();
        SignInPage signin = new SignInPage();
        AbstractPage baseas = new AbstractPage();
        try {

            baseas.proceedToPage("https://training.by/#/Home");
            home
                    .clickSignInButtom();
            signin
                    .enterEmail("incorrect@gmail.com")
                    .enterPassword("incorrectPassword")
                    .clickSignInButtom();
            Assert.assertTrue(" ", signin.checkErroeMasseg());


        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            DriverFactory.quitDriver();
        }
    }

    @Test
    public void verityTreaningSearchingSkills()throws Exception{
        HomePage home = new HomePage();
        SignInPage signin = new SignInPage();
        AbstractPage baseas = new AbstractPage();
        TrainingPage train = new TrainingPage();
        try {

            baseas.proceedToPage("https://training.by/#/Home");
            home
                    .clickSignInButtom();
            signin
                    .enterEmail("ivanhorintest@gmail.com")
                    .enterPassword("ivanhorintestPassword")
                    .clickSignInButtom();
            Assert.assertTrue(" ", home.checkUserInfo());
            home
                    .clickTrainingButtom();
            train
                    .clickSkillsDropDownButtom()
                    .skillsDropDownInput("Java");
            Assert.assertFalse(" ", train.skillsDropDownCheckResult("java"));
            train
                    .clearSkillsDropDownInput()
                    .skillsDropDownInput("Data");
            Assert.assertFalse(" ", train.skillsDropDownCheckResult("data"));
            train
                    .clearSkillsDropDownInput()
                    .skillsDropDownInput("Paskal");
            Assert.assertFalse(" ", train.skillsDropDownCheckVoidResult());

        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            DriverFactory.quitDriver();
        }
    }

}

