package otus.bdd.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import otus.bdd.support.UIGuiceScoped;

public class Hooks {

    @Inject
    private UIGuiceScoped guiceScoped;

    @After
    public void close() {
        if(guiceScoped.driver != null) {
            guiceScoped.driver.close();
            guiceScoped.driver.quit();
        }

    }
}
