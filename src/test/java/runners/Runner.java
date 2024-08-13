package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberReports.html","pretty"},
        features = "src/test/resources/features/wip",
        glue = "stepdefinitions",
        dryRun = false
        //tags = "@regression"
)

public class Runner {
}
