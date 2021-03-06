package cucumberOptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
        features = "src/test/java/features",
        glue="src/test/java/stepDefinition", //glue
        stepNotifications = true,
        dryRun = false,
        monochrome = true,
        /*   tags = "@BackPack",*/
        plugin = {"pretty","html:target/reportHTML"}
)

public class TestRunner extends AbstractTestNGCucumberTests {


}

