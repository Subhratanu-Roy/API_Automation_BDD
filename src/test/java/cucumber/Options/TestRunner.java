package cucumber.Options;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/feature/ValidatingPlace.feature", 
glue = "stepdefinitions",

plugin = {
		"html:target/CucumberReports/CucumberReport.html",
		"json:target/CucumberReports/CucumberReport.json" }, 
monochrome = true
//tags = "@AddUserAPI"

)
public class TestRunner extends AbstractTestNGCucumberTests{

}
