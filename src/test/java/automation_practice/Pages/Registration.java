package automation_practice.Pages;

import automation_practice.Configuration.DriverFactory;
import automation_practice.Helpers.DataFaker;
import automation_practice.Helpers.Screenshots;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Registration extends BasePage
{
    @FindBy(id = "id_gender2")
    private WebElement femaleTitleRadioButton;
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "days")
    private WebElement daysButton;
    @FindBy(id = "months")
    private WebElement monthsButton;
    @FindBy(id = "years")
    private WebElement yearsButton;
    @FindBy(id = "address1")
    private WebElement streetInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "id_state")
    private WebElement stateList;
    @FindBy(id = "postcode")
    private WebElement postcodeInput;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneNumberInput;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;
    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    private List<WebElement> errors;

    DataFaker dataFaker = new DataFaker();
    Logger logger = Logger.getLogger(Registration.class);

    public void fillRegistrationForm(boolean valid)
    {
        femaleTitleRadioButton.click();
        if (valid)
        {
            firstNameInput.sendKeys(dataFaker.setFirstName());
        }
        lastNameInput.sendKeys(dataFaker.setLastName());
        passwordInput.sendKeys(dataFaker.setPassword());
        new Select(daysButton).selectByIndex(20);
        new Select(monthsButton).selectByIndex(2);
        new Select(yearsButton).selectByValue("1989");
        streetInput.sendKeys(dataFaker.setAddress());
        cityInput.sendKeys(dataFaker.setCity());
        new Select(stateList).selectByIndex(34);
        postcodeInput.sendKeys("15678");
        mobilePhoneNumberInput.sendKeys(dataFaker.setMobilePhoneNumber());
    }

    @Step
    public void fillRegistrationFormWithValidValues()
    {
        logger.info("I am filling registration form with valid values");
        fillRegistrationForm(true);
        Screenshots.takeScreenshot(DriverFactory.getDriver());
        registerButton.click();
        logger.info("Registration form filled with valid values");
    }

    @Step
    public void fillRegistrationFormWithInvalidValues()
    {
        logger.info("I am filling registration form with invalid values");
        fillRegistrationForm(false);
        Screenshots.takeScreenshot(DriverFactory.getDriver());
        registerButton.click();
        logger.info("Registration form filled with invalid values");
    }

    @Step
    public void checkCorrectionOfErrorsList()
    {
        logger.info("I am checking correction of errors list");
        assertThat(getAlertMessageContent().size()).isEqualTo(1);
        assertThat(getAlertMessageContent().get(0)).isEqualTo("firstname is required.");
        logger.info("Errors list checked");
    }

    private List<String> getAlertMessageContent()
    {
        List<String> errorMessages = new ArrayList<>();
        for (WebElement error : errors)
        {
           errorMessages.add(error.getText());
        }
        return errorMessages;
    }

}
