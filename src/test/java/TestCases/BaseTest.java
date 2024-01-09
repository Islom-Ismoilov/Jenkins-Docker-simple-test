package TestCases;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver == null){
            initializeDriver();

        }
        return driver;
    }

    @BeforeClass
    public static void initializeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void quitDriver(){
        if (driver != null){
            driver.quit();
        }
    }
}
