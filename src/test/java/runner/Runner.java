package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(tags = "tag", features = "src/test/resources/feature", 
glue = "stepDefinition",dryRun=false)
 
public class Runner extends AbstractTestNGCucumberTests {
 
}