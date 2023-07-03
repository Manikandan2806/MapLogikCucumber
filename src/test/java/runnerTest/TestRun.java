package runnerTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
	(features = {"Features/SkillEnhancement.feature"},
	glue = "stepDefinitions",
	dryRun = false,
	monochrome = true,
	plugin = {"pretty", "html:test-output"},
	tags = "@testing"

		)
public class TestRun {

}
