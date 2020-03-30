package automation_practice.Pages;

import automation_practice.Configuration.DriverFactory;
import automation_practice.Helpers.Screenshots;
import automation_practice.Helpers.WaitForElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage

{
    @FindBy(id = "columns")
    private WebElement basePageContent;

    Logger logger = Logger.getLogger(BasePage.class);

    public BasePage()
    {
        logger.info("Elements on page initiated");
        PageFactory.initElements(DriverFactory.getDriver(), this);
        WaitForElement.WaitForElementToBeDisplayed(basePageContent);
    }

}
