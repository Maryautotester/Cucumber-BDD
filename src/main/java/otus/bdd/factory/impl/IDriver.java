package otus.bdd.factory.impl;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import org.openqa.selenium.WebDriver;
import otus.bdd.exceptions.BrowserNotSupportedException;

public interface IDriver {
    WebDriver newDriver();

    default void downloadLocalWebDriver(String browser) throws BrowserNotSupportedException {
        Config wdmConfig = WebDriverManager.getInstance().config();
        wdmConfig.setAvoidBrowserDetection(true);

        if (!browser.isEmpty()) {
            switch (browser) {
                case "chrome":
                    wdmConfig.setChromeDriverVersion(browser);
                    break;
                default:
                    throw new BrowserNotSupportedException(browser);
            }
        }

        WebDriverManager.getInstance(browser).setup();
    }
}
