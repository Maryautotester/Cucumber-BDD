package otus.bdd.factory;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import otus.bdd.exceptions.BrowserNotSupportedException;
import otus.bdd.factory.impl.ChromeWebDriver;

public class FactoryDriver {

    public EventFiringWebDriver getDriver(String browserName) throws BrowserNotSupportedException {

        switch (browserName) {
            case "chrome": {
                ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
                chromeWebDriver.downloadLocalWebDriver(browserName);
                return new EventFiringWebDriver(chromeWebDriver.newDriver());
            }
            default:
                try {
                    throw new BrowserNotSupportedException(browserName);
                } catch (BrowserNotSupportedException ex) {
                    ex.printStackTrace();
                    return null;
                }

        }

    }
}
