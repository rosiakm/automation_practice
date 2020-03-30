package automation_practice.Pages;

import automation_practice.Configuration.DriverFactory;
import automation_practice.Helpers.Screenshots;
import automation_practice.Helpers.WaitForElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

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
    public SignIn openSignInPage()
    {
        logger.info("I am opening the SignIn page");
        signInButton.click();
        Screenshots.takeScreenshot(DriverFactory.getDriver());
        return new SignIn();
    }

    @Step
    public SearchResults openSearchResults()
    {
        logger.info("I am searching for dress");
        searchInput.sendKeys("dress" + Keys.ENTER);
        Screenshots.takeScreenshot(DriverFactory.getDriver());
        return new SearchResults();
    }

}
