package automation_practice.Helpers;

import automation_practice.Configuration.DriverFactory;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshots
{
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver)
    {
        return ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
