package automation_practice.Tests;

import automation_practice.Configuration.DriverSetUp;
import automation_practice.Helpers.MyTestRunner;
import automation_practice.Pages.Home;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MyTestRunner.class)
public class ShoppingCartTest extends DriverSetUp
{
    Home home = new Home();

    @Test
    public void addingProductTest()
    {
        home.openSearchResults()
            .checkThatSearchPageOpened()
            .addToCart()
            .openShoppingCart()
            .checkThatShoppingCartOpened()
            .checkTheSizeOfShoppingCart();
    }

    @Test
    public void addingTwoTheSameProductsTest()
    {
        home.openSearchResults()
            .checkThatSearchPageOpened()
            .addToCart()
            .addToCart()
            .openShoppingCart()
            .checkThatShoppingCartOpened()
            .checkTheSizeOfShoppingCartWithSomeProducts();
    }

    @Test
    public void addingTwoDifferentProductsTest()
    {
        home.openSearchResults()
            .checkThatSearchPageOpened()
            .addToCart()
            .addDifferentProductToCart()
            .openShoppingCart()
            .checkThatShoppingCartOpened()
            .checkTheSizeOfShoppingCartWithSomeProducts();
    }

    @Test
    public void deletingProductTest()
    {
        home.openSearchResults()
            .checkThatSearchPageOpened()
            .addToCart()
            .openShoppingCart()
            .deleteItemFromShoppingCart()
            .checkThatShoppingCartIsEmpty();
    }
}
