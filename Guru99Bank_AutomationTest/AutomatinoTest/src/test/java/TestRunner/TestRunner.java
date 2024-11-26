package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/Features", glue = "TestSteps", tags = "@NewCustomer",
plugin = {"pretty",
        "html:target/reports/GuruReport.html",
        "json:target/reports/GuruReport.json",
        "junit:target/reports/GuruReport.xml",
        "rerun:target/reports/GuruReport.txt"
})
public class TestRunner {

}
