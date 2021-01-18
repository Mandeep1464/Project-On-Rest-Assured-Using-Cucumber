package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/features",
		glue= {"stepDefinition"},
		plugin = {"html:target/test-report","junit:target/junit-xml-report.xml","json:target/json-report.json"})
public class testRunnerWithTestNG extends AbstractTestNGCucumberTests{

}
