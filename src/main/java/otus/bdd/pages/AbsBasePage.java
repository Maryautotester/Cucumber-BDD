package otus.bdd.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.inject.Inject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import otus.bdd.annotations.Path;
import otus.bdd.exceptions.PathEmptyException;
import otus.bdd.pageobject.AbsPageObject;
import otus.bdd.support.UIGuiceScoped;


public abstract class AbsBasePage<T> extends AbsPageObject<T> {

    private String baseurl = System.getProperty("base.url", "https://otus.ru");
    @Inject
    public AbsBasePage(UIGuiceScoped scenarioScoped) {
        super(scenarioScoped);
    }
    @FindBy(xpath = "//img[contains(@alt, \"Logo\")]//..")
    WebElement headerMain;

    @FindBy(xpath = "//h1")
    private WebElement header;

    public T pageHeaderShouldBeSameAs(String header) {
        assertThat(this.header.getText())
                .as("Header should be %s", header)
                .contains(header.replace("Специализация ", ""));
        return (T) this;

    }


    private String getPath() throws PathEmptyException{
        Path path = getClass().getAnnotation(Path.class);
        if (path != null){
            return path.value();
        }
        throw new PathEmptyException();
    }

    public void open() throws PathEmptyException {
        String url = baseurl + getPath();
        guiceScoped.driver.get(url);
    }
}
