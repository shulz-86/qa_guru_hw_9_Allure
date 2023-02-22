package ru.shulz;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JobSearchSelenideTest {

    @Test
    public void testJobSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://trudvsem.ru/");

        $(".home__search-control").click();
        $(".home__search-control").sendKeys("менеджер");
        $(".home__search-control").submit();

        $(withText("Вакансии на должность менеджер")).shouldHave(Condition.exist);
        //$(byText("Вакансии на должность менеджер")).shouldBe(Condition.visible);
    }
}
