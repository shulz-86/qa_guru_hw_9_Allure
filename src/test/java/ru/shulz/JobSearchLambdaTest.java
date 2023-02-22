package ru.shulz;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class JobSearchLambdaTest {
    private static final String MANAGER = "менеджер";

    @Test
    public void testJobSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу портала Работа России", () -> {
            open("https://trudvsem.ru/");
        });

        step("Через поисковую строку ищем вакансию " + MANAGER, () -> {
            $(".home__search-control").click();
            $(".home__search-control").sendKeys(MANAGER);
            $(".home__search-control").submit();
        });

        step("Проверяем, что нашлись вакансии " + MANAGER + "(заголовок)", () -> {
            $(withText("Вакансии на должность " + MANAGER)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForJob(MANAGER);
        steps.checkJob(MANAGER);
    }
}
