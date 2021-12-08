package ExecuteAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features ={"src/test/java/bddworks.feature"},
        glue = {"All_Tests"}
)

public class ExecuteAll {
}