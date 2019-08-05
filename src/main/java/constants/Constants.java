package constants;

public interface Constants {
    interface DriverConfigs{

        String CHROME_NAME = "webdriver.chrome.driver";

        String CHROME_DRIVER_LOCATIONS ="src/main/resources/chromedriver.exe";

    }

    interface BusinessConfigs{
        String BASE_URL = "https://training.by";
        String BASE_HOME_URL = BASE_URL +"/#/Home";
    }

}
