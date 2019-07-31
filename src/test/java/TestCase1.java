import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

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
    public void hui2()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#/Home");

    }

}
