package automation_practice.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory
{
    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        if(driver == null)
        {
            getDriverType(DriverType.CHROME);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.get("http://automationpractice.com/index.php");
        }
        return driver;
    }

    private static void getDriverType(DriverType driverType)
    {
        switch (driverType)
        {
            case CHROME:
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            break;
            case FIREFOX:
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            break;
            case IE:
            {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            break;

        }
    }

    public static void quit()
    {
        if(driver != null)
        {
            driver.quit();
        }
        driver = null;
    }
}
