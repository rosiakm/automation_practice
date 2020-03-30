package automation_practice.Helpers;

import automation_practice.Configuration.DriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitForElement
{
    public static void WaitForElementToBeDisplayed(WebElement element)
    {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(DriverFactory.getDriver());
        fluentWait.withTimeout(Duration.ofSeconds(10))
                  .pollingEvery(Duration.ofMillis(1000))
                  .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }
}
