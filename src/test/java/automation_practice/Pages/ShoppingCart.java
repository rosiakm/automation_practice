package automation_practice.Pages;

import automation_practice.Configuration.DriverFactory;
import automation_practice.Helpers.Screenshots;
import automation_practice.Helpers.WaitForElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCart extends BasePage
{
    @FindBy(xpath = "//span[@class='navigation_page']")
    private WebElement navigator;
    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr")
    private List<WebElement> products;
    @FindBy(xpath = "//i[@class='icon-trash']")
    private WebElement deleteItemButton;
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement alertWarning;
    @FindBy(xpath = "//td[@class='cart_quantity text-center']/input[@class='cart_quantity_input form-control grey']")
    private WebElement quantityTextAttribute;

    Logger logger = Logger.getLogger(ShoppingCart.class);

    @Step
    public ShoppingCart deleteItemFromShoppingCart()
    {
        logger.info("I am deleting item from shopping cart");
        deleteItemButton.click();
        WaitForElement.WaitForElementToBeDisplayed(alertWarning);
        Screenshots.takeScreenshot(DriverFactory.getDriver());
        logger.info("Item deleted from shopping cart");
        return this;
    }

    @Step
    public ShoppingCart checkThatShoppingCartOpened()
    {
        logger.info("I am checking that shopping cart opened correctly");
        String actualNavigator = navigator.getText();
        String expectedNavigator = "Your shopping cart";
        assertThat(actualNavigator).isEqualTo(expectedNavigator);
        logger.info("Shopping cart opened correctly");
        return this;
    }

    @Step
    public ShoppingCart checkTheSizeOfShoppingCart()
    {
        logger.info("I am checking size of shopping cart");
        assertThat(getShoppingTableContent().size()).isEqualTo(1);
        logger.info("Size checked");
        return this;
    }

    @Step
    public ShoppingCart checkTheSizeOfShoppingCartWithSomeProducts()
    {
        logger.info("I am checking if there is only one item in shopping cart");
        if(getShoppingTableContent().size() == 1)
        {
            logger.info("There is one item in shopping cart");
            logger.info("I am checking quantity of selected product ");
            String text = quantityTextAttribute.getAttribute("value");
            System.out.println(text);
            assertThat(text).isEqualTo("2");
            logger.info("Quantity checked");
        }
        else
            logger.info("There is more than one item");
            logger.info("I am checking how many items selected");
            assertThat(getShoppingTableContent().size()).isEqualTo(2);
            logger.info("The number of items checked");
        return this;
    }

    @Step
    public ShoppingCart checkThatShoppingCartIsEmpty()
    {
        logger.info("I am checking if shopping cart is empty");
        String actualAlert = alertWarning.getText();
        String expectedAlert = "Your shopping cart is empty.";
        assertThat(getShoppingTableContent().size()).isEqualTo(0);
        assertThat(actualAlert).isEqualTo(expectedAlert);
        logger.info("Shopping cart checked");
        return this;
    }

    public List<String> getShoppingTableContent()
    {
        List<String> allProducts = new ArrayList<>();
        for(WebElement product : products)
        {
            allProducts.add(product.getTagName());
        }
        return allProducts;
    }
}
