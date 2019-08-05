import constants.Constants;
import driver.DriverFactory;
import junit.framework.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;

public abstract class BaseTest extends DriverFactory {
    //  private Logger LOG = Logger.getLogger(BaseTest.class );
    private Test test;

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod (@Optional(value = Constants.DriverConfigs.CHROME_NAME) final String browserName){
        initDriver(browserName);
       // LOG = Logger.getLogger(me)
    }
}
