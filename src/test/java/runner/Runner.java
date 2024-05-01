package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/java/features/IncidentManagement.feature"},glue= {"stepDefinition","runner"})
public class Runner extends AbstractTestNGCucumberTests {

}
