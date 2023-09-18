package otus.bdd.steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import otus.bdd.exceptions.PathEmptyException;
import otus.bdd.pages.OtusMainPage;
import otus.bdd.support.UIGuiceScoped;

public class MainPageSteps {

    @Inject
    private OtusMainPage mainPage;
    @Inject
    UIGuiceScoped guiceScoped;

    @Пусть("Открыта главная страница")
    public void openMainPage() throws PathEmptyException {
        mainPage.open();
    }

    @Если("Кликнуть на плитку курса {string}")
    public void filterCourseTest(String courseName) {
        mainPage.clickCourseThumbsByTitle(courseName);
    }

    @Если("Получаем название самого раннего курса")
    public void getCourseNameEarliest() {
        guiceScoped.courseNameEarliest = mainPage.getCourseNameByStartDate(true);
    }
    @Если("Получаем название самого позднего курса")
    public void getCourseNameLatest() {
        guiceScoped.courseNameLatest = mainPage.getCourseNameByStartDate(false);
    }

    @Если("Кликнуть на плитку самого раннего курса")
    public void clickOnEarliestCourse() {
        mainPage.clickCourseThumbsByTitle(guiceScoped.courseNameEarliest);
    }
    @Если("Кликнуть на плитку самого позднего курса")
    public void clickOnLatestCourse() {
        mainPage.clickCourseThumbsByTitle(guiceScoped.courseNameLatest);
    }
    @Тогда("Проверяем название страницы выбранного курса {string}")
    public void checkCoursePageName(String header) {
        mainPage.pageHeaderShouldBeSameAs(header);
    }
    @Тогда("Откроется страница раннего курса")
    public void checkCoursePageTitleEarliest() {
        mainPage.pageHeaderShouldBeSameAs(guiceScoped.courseNameEarliest);
    }
    @Тогда("Откроется страница позднего курса")
    public void checkCoursePageTitleLatest() {
        mainPage.pageHeaderShouldBeSameAs(
                guiceScoped.courseNameLatest.replaceAll(
                        "Специализация сетевой инженер", "Network Engineer"));
    }


}
