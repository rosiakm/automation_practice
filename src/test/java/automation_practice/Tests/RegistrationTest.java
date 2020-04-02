package automation_practice.Tests;

import automation_practice.Configuration.DriverSetUp;
import automation_practice.Pages.Home;
import automation_practice.Pages.Registration;
import automation_practice.Pages.SignIn;
import automation_practice.Pages.User;
import org.junit.Test;

public class RegistrationTest extends DriverSetUp
{
    Home home = new Home();
    SignIn signIn = new SignIn();
    Registration registration = new Registration();
    User user = new User();

    @Test
    public void registrationWithValidValuesTest()
    {
        home.openSignInPage();
        signIn.createAnAccount();
        registration.fillRegistrationFormWithValidValues();
        user.checkThatUserCorrectlyCreated();
    }

    @Test
    public void registrationWithInvalidValuesTest()
    {
        home.openSignInPage();
        signIn.createAnAccount();
        registration.fillRegistrationFormWithInvalidValues();
        registration.checkCorrectionOfErrorsList();
    }
}
