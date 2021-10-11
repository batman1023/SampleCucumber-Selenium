package cucumberOptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue="stepDefinition", //glue
        stepNotifications = true,
        dryRun = false,
        monochrome = true,
    /*    tags = "@BackPack",*/
        plugin = {"pretty","html:target/reportHTML"}
)

public class TestRunner {



    }

