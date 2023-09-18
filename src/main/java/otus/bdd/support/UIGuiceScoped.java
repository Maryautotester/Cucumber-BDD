package otus.bdd.support;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;


@ScenarioScoped
public class UIGuiceScoped {
    public WebDriver driver = null;
    public String courseNameEarliest;
    public String courseNameLatest;
}
