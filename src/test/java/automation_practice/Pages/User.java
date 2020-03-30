package automation_practice.Pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class User extends BasePage
{
    @FindBy(xpath = "//div[@id='center_column']/h1")
    private WebElement pageHeader;

    Logger logger = Logger.getLogger(User.class);

    @Step
    public void checkThatUserCorrectlyCreated()
    {
        logger.info("I am checking that user was correctly created");
        String actualPageHeader = pageHeader.getText();
        String expectedPageHeader = "MY ACCOUNT";
        assertThat(actualPageHeader).isEqualTo(expectedPageHeader);
        logger.info("User created correctly");
    }
}
