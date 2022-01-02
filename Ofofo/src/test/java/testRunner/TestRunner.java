package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
				glue="stepDefiniton",
				tags="@SeleniumTest",
				monochrome = true,
				plugin= {"json:target/cucumber2.json"})
public class TestRunner {

}
