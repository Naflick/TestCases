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

public class HardCodeTestCase {
    @Test
    public void verityUserIsSuccessfullyLogetIn()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        try {
            driver.get("https://training.by/#/Home");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'signin')]/span"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInEmail"))).sendKeys("ivanhorintest@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInPassword"))).sendKeys("ivanhorintestPassword");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'form__sign-in')]"))).click();

            Assert.assertTrue("",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'user-info__name')]"))).isDisplayed());
        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            driver.quit();
        }
    }
    @Test
    public void verityUserIsNoSuccessfullyLogetIn()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        try {
            driver.get("https://training.by/#/Home");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'signin')]/span"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInEmail"))).sendKeys("incorrect@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInPassword"))).sendKeys("incorrectPassword");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'form__sign-in')]"))).click();

            Assert.assertTrue("",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'error-message ng-binding')]"))).isDisplayed());
        }catch (Exception e){
            throw new Exception(e);
        }
        finally {
            driver.quit();
        }
    }

    @Test
    public void verityTreaningSearchingSkills()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        try {
            driver.get("https://training.by/#/Home");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'signin')]/span"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInEmail"))).sendKeys("ivanhorintest@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInPassword"))).sendKeys("ivanhorintestPassword");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'form__sign-in')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'links-row')]//*[contains(@class,'topNavItem training')]"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Skills')]/..//*[contains(@ng-click,'openSkillsDropDown')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-skills drop-down-visibility')]/input"))).sendKeys("Java");
            Assert.assertFalse("",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]//label[contains(text(),'')]"))).getText().contains("java"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-skills drop-down-visibility')]/input"))).clear();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-skills drop-down-visibility')]/input"))).sendKeys("Data");
            Assert.assertFalse("",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]//label[contains(text(),'')]"))).getText().contains("data"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-skills drop-down-visibility')]/input"))).clear();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-skills drop-down-visibility')]/input"))).sendKeys("Paskal");
            List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'drop-down-skills')]//*[contains(@class,'drop-down__input-search__list')]"));
            Assert.assertFalse("We have any result", list.size() == 0);
        } catch (Exception e){
            throw new Exception(e);
        }
        finally {
            driver.quit();
        }
    }

    @Test
    public void verityNewsPageObject()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        try {
            driver.get("https://training.by/#/Home");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'signin')]/span"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInEmail"))).sendKeys("ivanhorintest@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInPassword"))).sendKeys("ivanhorintestPassword");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'form__sign-in')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'links-row')]//*[contains(@class,'topNavItem news')]"))).click();

            Assert.assertTrue("No News",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'tab-nav__list separated-list')]//span[contains(text(),'News')]"))).isDisplayed());
            Assert.assertTrue("No Success Stories",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'tab-nav__list separated-list')]//span[contains(text(),'Success Stories')]"))).isDisplayed());
            Assert.assertTrue("No Materials",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'tab-nav__list separated-list')]//span[contains(text(),'Materials')]"))).isDisplayed());
            Assert.assertTrue("No Videos",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'tab-nav__list separated-list')]//span[contains(text(),'Videos')]"))).isDisplayed());
        } catch (Exception e){
            throw new Exception(e);
        }
        finally {
            driver.quit();
        }
    }

    @Test
    public void verityTreaningSearchingLocations()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        try {
            driver.get("https://training.by/#/Home");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'signin')]/span"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInEmail"))).sendKeys("ivanhorintest@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInPassword"))).sendKeys("ivanhorintestPassword");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'form__sign-in')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'links-row')]//*[contains(@class,'topNavItem training')]"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Locations')]/..//*[contains(@ng-click,'openLocationsDropDown')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-locations drop-down-visibility')]/input"))).sendKeys("Kyiv");
            WebElement searchingResult = driver.findElement(By.xpath("//*[contains(@class,'drop-down-locations')]//*[contains(@class,'drop-down__input-search__list')]//label[contains(text(),'')]"));
            Assert.assertTrue("",(searchingResult.getText().contains("Kyiv"))||(searchingResult.getText().contains("Ukraine")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-locations drop-down-visibility')]/input"))).clear();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'drop-down drop-down-locations drop-down-visibility')]/input"))).sendKeys("Los Angeles");
            List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'drop-down-locations')]//*[contains(@class,'drop-down__input-search__list')]"));
            Assert.assertFalse("We have any result", list.size() == 0);
        } catch (Exception e){
            throw new Exception(e);
        }
        finally {
            driver.quit();
        }
    }




}
