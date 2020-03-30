package automation_practice.Configuration;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class DriverSetUp
{
    private WebDriver driver;
    Logger logger = Logger.getLogger(DriverSetUp.class);

    @Before
    public void setUpDriver()
    {
        logger.info("On test start");
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown()
    {
        logger.info("On test quit");
        DriverFactory.quit();
    }
}
