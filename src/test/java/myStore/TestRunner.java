package myStore;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Harshala on 01/02/2018.
 */


@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/features/login.feature",
                tags = {"@validLogin"},
                plugin = "html: target/HTMLReports"
)
public class TestRunner {
}

