package Tek_UI_BDD_FrameWork.Test_Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
      features = "src/test/resources/Test_Features",
        glue = "",
        tags = "",
        plugin = {
              "html:target/html_report/report.html",
                "json:target/json_report/report.json"
        }
)

public class TestRunner{

}

