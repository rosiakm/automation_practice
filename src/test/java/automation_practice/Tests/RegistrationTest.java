package automation_practice.Tests;

import automation_practice.Configuration.DriverSetUp;
import automation_practice.Helpers.MyTestRunner;
import automation_practice.Pages.Home;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MyTestRunner.class)
public class RegistrationTest extends DriverSetUp
{
    Home home = new Home();

    @Test
    public void registrationWithValidValuesTest()
    {
        home.openSignInPage()
            .createAnAccount()
            .fillRegistrationFormWithValidValues()
            .checkThatUserCorrectlyCreated();
    }

    @Test
    public void registrationWithInvalidValuesTest()
    {
        home.openSignInPage()
            .createAnAccount()
            .fillRegistrationFormWithInvalidValues()
            .checkCorrectionOfErrorsList();
    }
}
