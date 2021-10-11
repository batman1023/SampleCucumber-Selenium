package base;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;


public class Base {
    public static WebDriver driver;


    public static WebDriver getDriver() throws IOException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Documents\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;

    }
}
