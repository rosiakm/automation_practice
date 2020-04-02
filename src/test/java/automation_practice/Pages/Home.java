package automation_practice.Pages;

import automation_practice.Configuration.DriverFactory;
import automation_practice.Helpers.Screenshots;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends BasePage
{
    @FindBy(linkText = "Sign in")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;
    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    Logger logger = Logger.getLogger(Home.class);

    public Home() {super(); }

    @Step
    public void openSignInPage()
    {
        logger.info("I am opening the SignIn page");
        signInButton.click();
        Screenshots.takeScreenshot(DriverFactory.getDriver());
    }

    @Step
    public void openSearchResults()
    {
        logger.info("I am searching for dress");
        searchInput.sendKeys("dress" + Keys.ENTER);
        Screenshots.takeScreenshot(DriverFactory.getDriver());
    }

}
