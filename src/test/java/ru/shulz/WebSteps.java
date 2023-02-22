package ru.shulz;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

            @Step("Открываем главную страницу портала Работа России")
            public void openMainPage() {
                open("https://trudvsem.ru/");
            }

            @Step("Через поисковую строку ищем вакансию менеджера")
            public void searchForJob(String title) {
                $(".home__search-control").click();
                $(".home__search-control").sendKeys("менеджер");
                $(".home__search-control").submit();
            }

            @Step("Проверяем, что нашлись вакансии менеджер (заголовок)")
            public void checkJob(String title) {
                $(withText("Вакансии на должность " + title)).should(Condition.exist);
            }
        }
