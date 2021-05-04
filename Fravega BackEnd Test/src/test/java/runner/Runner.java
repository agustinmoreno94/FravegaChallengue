package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/features",
        glue = ("Steps"),
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:cucumber-reports/reportFravega.html"}
)

public class Runner {
}
