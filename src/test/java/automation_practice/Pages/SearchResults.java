package automation_practice.Pages;

import automation_practice.Configuration.DriverFactory;
import automation_practice.Helpers.Screenshots;
import automation_practice.Helpers.WaitForElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResults extends BasePage
{
    @FindBy(xpath = "//div[@class='product-container']//img[@title='Printed Summer Dress']")
    private WebElement firstProductImage;
    @FindBy(xpath = "//div[@class='product-container']//img[@title='Printed Chiffon Dress']")
    private WebElement secondProductImage;
    @FindBy(xpath = "//a[@class='quick-view']")
    private WebElement firstProductViewButton;
    @FindBy(xpath = "//a[@data-id-product='7']")
    private WebElement secondAddCartButton;
    @FindBy(id = "add_to_cart")
    private WebElement addToCartButton;
    @FindBy(id = "color_14")
    private WebElement greenColorButton;
    @FindBy(id = "group_1")
    private WebElement sizeSelectList;
    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "//span[@class='navigation_page']")
    private WebElement navigator;
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement viewMyShoppingCartButton;

    Logger logger = Logger.getLogger(SearchResults.class);

    @Step
    public SearchResults addToCart()
    {
        logger.info("I am adding a dress to a shopping cart");
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(firstProductImage).perform();
        WaitForElement.WaitForElementToBeDisplayed(firstProductViewButton);
        firstProductViewButton.click();
        DriverFactory.getDriver().switchTo().frame(0);
        new Select(sizeSelectList).selectByValue("3");
        greenColorButton.click();
        Screenshots.takeScreenshot(DriverFactory.getDriver());
        addToCartButton.click();
        DriverFactory.getDriver().switchTo().defaultContent();
        WaitForElement.WaitForElementToBeDisplayed(continueShoppingButton);
        continueShoppingButton.click();
        logger.info("Dress added");
        return this;
    }

    @Step
    public SearchResults addDifferentProductToCart()
    {
        logger.info("I am adding another dress to a shopping cart");
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(secondProductImage).perform();
        WaitForElement.WaitForElementToBeDisplayed(secondAddCartButton);
        secondAddCartButton.click();
        WaitForElement.WaitForElementToBeDisplayed(continueShoppingButton);
        continueShoppingButton.click();
        logger.info("Another dress added");
        return this;
    }

    @Step
    public ShoppingCart openShoppingCart()
    {
        logger.info("I am opening a shopping cart");
        viewMyShoppingCartButton.click();
        Screenshots.takeScreenshot(DriverFactory.getDriver());
        return new ShoppingCart();
    }

    @Step
    public SearchResults checkThatSearchPageOpened()
    {
        logger.info("I am checking that search page opened correctly");
        String actualPageHeader = navigator.getText();
        String expectedPageHeader = "Search";
        assertThat(actualPageHeader).contains(expectedPageHeader);
        logger.info("Search page opened correctly");
        return this;
    }
}
