package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"StepDefinitions"},
        plugin = "json:target/jsonReport/cucumber-report.json",
//        plugin = "html:target/HTMLReports/cucumber-report.html",
        tags ="@AddPlace"
)
public class TestRunner {
}
