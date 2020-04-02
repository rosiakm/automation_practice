package automation_practice.Pages;

import automation_practice.Configuration.DriverFactory;
import automation_practice.Helpers.DataFaker;
import automation_practice.Helpers.Screenshots;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn extends BasePage
{
    public SignIn()
    {
        super();
    }

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(name = "SubmitCreate")
    private WebElement createAnAccountButton;

    DataFaker dataFaker = new DataFaker();
    Logger logger = Logger.getLogger(SignIn.class);

    @Step
    public void createAnAccount()
    {
        logger.info("I am creating new account");
        emailInput.sendKeys(dataFaker.setEmailAddress());
        Screenshots.takeScreenshot(DriverFactory.getDriver());
        createAnAccountButton.click();
    }
}
