package driver;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DriverFactory {
    private static WebDriver webDriver;

    public static void initDriver(final String browserName){
        if (webDriver == null) {
            if(browserName == "Chrome" ) {
                System.setProperty(Constants.DriverConfigs.CHROME_NAME, Constants.DriverConfigs.CHROME_DRIVER_LOCATIONS);
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
            }
        }
    }



    public static WebDriver getDriver(){
        return webDriver;
    }

    public static void quitDriver(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
}