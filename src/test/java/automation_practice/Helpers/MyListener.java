package automation_practice.Helpers;

import automation_practice.Configuration.DriverFactory;
import org.apache.log4j.Logger;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class MyListener extends RunListener
{
    Logger logger = Logger.getLogger(MyListener.class);

    @Override
    public void testFailure(Failure failure) throws Exception
    {
        super.testFailure(failure);
        logger.info(failure.getMessage());
        logger.info("Test failed. I am going to make a screenshot");
        Screenshots.takeScreenshot(DriverFactory.getDriver());
    }
}
