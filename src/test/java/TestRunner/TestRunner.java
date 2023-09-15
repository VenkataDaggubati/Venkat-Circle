package TestRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        features = "src/main/resources/Feature/KneeReplacementAppointment.feature",
        glue = "TestRunner")
public class TestRunner {
}
