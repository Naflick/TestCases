import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class TestCase1 {
    @Test
    public void verityUserIsSuccessfullyLogetIn()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#/Home");

        WebElement singInButtom = driver.findElement(By.xpath("//*[contains(@class,'signin')]/span"));
        singInButtom.click();
        WebElement mailInput =driver.findElement(By.id("signInEmail"));
        mailInput.sendKeys("ivanhorintest@gmail.com");
        WebElement passwordInput =driver.findElement(By.id("signInPassword"));
        passwordInput.sendKeys("ivanhorintestPassword");
        WebElement logInButtom = driver.findElement(By.xpath("//*[contains(@class,'form__sign-in')]"));
        logInButtom.click();


        WebElement userInfoName = driver.findElement(By.xpath("//*[contains(@class,'user-info__name')]"));
        Assert.assertTrue("Username is NOT display", userInfoName.isDisplayed());
        driver.quit();
    }
    @Test
    public void verityUserIsNoSuccessfullyLogetIn()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#/Home");

        WebElement singInButtom = driver.findElement(By.xpath("//*[contains(@class,'signin')]/span"));
        singInButtom.click();
        WebElement mailInput =driver.findElement(By.id("signInEmail"));
        mailInput.sendKeys("incorrect@gmail.com");
        WebElement passwordInput =driver.findElement(By.id("signInPassword"));
        passwordInput.sendKeys("incorrectPassword");
        WebElement logInButtom = driver.findElement(By.xpath("//*[contains(@class,'form__sign-in')]"));
        logInButtom.click();

        WebElement userInfoName = driver.findElement(By.xpath("//*[contains(@class,'error-message ng-binding')]"));
        Assert.assertTrue("No error message",userInfoName.isDisplayed());
        driver.quit();

    }
    @Test
    public void verityTreaningSearchingWords()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        try {


            driver.get("https://training.by/#/Home");

        /*WebElement singInButtom = driver.findElement(By.xpath("//*[contains(@class,'signin')]/span"));
        singInButtom.click();*/
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'signin')]/span"))).click();
            WebElement mailInput = driver.findElement(By.id("signInEmail"));
            mailInput.sendKeys("ivanhorintest@gmail.com");
            WebElement passwordInput = driver.findElement(By.id("signInPassword"));
            passwordInput.sendKeys("ivanhorintestPassword");
            WebElement logInButtom = driver.findElement(By.xpath("//*[contains(@class,'form__sign-in')]"));
            logInButtom.click();
            WebElement trainingListButtom = driver.findElement(By.xpath("//*[contains(@class,'links-row')]//*[contains(@class,'topNavItem training')]"));
            trainingListButtom.click();


            WebElement filtrButtom = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Skills')]/..//*[contains(@class,'arrow-icon')]")));
            filtrButtom.click();
            WebElement filtrSearchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down-skills')]/input")));
            filtrSearchInput.sendKeys("Java");
            WebElement listSearched = driver.findElement(By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]//label[contains(text(),'')]"));
            Assert.assertFalse("We have any result", listSearched.getText().contains("java"));
            filtrSearchInput.clear();


            filtrSearchInput.sendKeys("Data");
            listSearched = driver.findElement(By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]//label[contains(text(),'')]"));
            elementText = listSearched.getText();
            check = elementText.contains("data");
            Assert.assertFalse("We have any result", check);
            filtrSearchInput.clear();


            filtrSearchInput.sendKeys("Paskal");
            List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]"));
            Assert.assertFalse("We have any result", list.size() == 0);
        } catch (Exception e){
            throw new Exception(e);
        }
        finally {
            driver.quit();
        }
    }




}
