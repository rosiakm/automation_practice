package automation_practice.Tests;

import automation_practice.Configuration.DriverSetUp;
import automation_practice.Pages.*;
import org.junit.Test;

public class ShoppingCartTest extends DriverSetUp
{
    Home home = new Home();
    SearchResults searchResults = new SearchResults();
    ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    public void addingProductTest()
    {
        home.openSearchResults();
        searchResults.checkThatSearchPageOpened();
        searchResults.addToCart();
        searchResults.openShoppingCart();
        shoppingCart.checkThatShoppingCartOpened();
        shoppingCart.checkTheSizeOfShoppingCart();
    }

    @Test
    public void addingTwoTheSameProductsTest()
    {
        home.openSearchResults();
        searchResults.checkThatSearchPageOpened();
        searchResults.addToCart();
        searchResults.addToCart();
        searchResults.openShoppingCart();
        shoppingCart.checkThatShoppingCartOpened();
        shoppingCart.checkTheSizeOfShoppingCartWithSomeProducts();
    }

    @Test
    public void addingTwoDifferentProductsTest()
    {
        home.openSearchResults();
        searchResults.checkThatSearchPageOpened();
        searchResults.addToCart();
        searchResults.addDifferentProductToCart();
        searchResults.openShoppingCart();
        shoppingCart.checkThatShoppingCartOpened();
        shoppingCart.checkTheSizeOfShoppingCartWithSomeProducts();
    }

    @Test
    public void deletingProductTest()
    {
        home.openSearchResults();
        searchResults.checkThatSearchPageOpened();
        searchResults.addToCart();
        searchResults.openShoppingCart();
        shoppingCart.deleteItemFromShoppingCart();
        shoppingCart.checkThatShoppingCartIsEmpty();
    }
}
