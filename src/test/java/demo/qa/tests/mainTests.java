package demo.qa.tests;

import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo.qa.BaseTest;
import demo.qa.pages.Main;
import demo.qa.pages.Repos;
import demo.qa.pages.Search;
import demo.qa.steps.StepsWeb;

public class mainTests extends BaseTest {

    private static final String REPO_LINK = "Azaze1o/HW_8";

    private static final String ISSUE_NAME = "Test for HW_9";

    Main mainPage = new Main();

    Search searchPage = new Search();

    Repos repoPage = new Repos();

    @Test
    @DisplayName("selenide")
    public void checkNameIssueSelenide() {

        mainPage.openPage().searchInputClick().searchInputSetValue(REPO_LINK).searchInputSubmit();
        searchPage.repoLinkClick();
        repoPage.issueTabClick().checkIssueTitle(ISSUE_NAME);
    }

    @Test
    @DisplayName("lamda step")
    public void checkNameIssueLambdaOpen() {

        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Ищем репозиторий " + REPO_LINK, () -> {
            mainPage.searchInputClick().searchInputSetValue(REPO_LINK).searchInputSubmit();
        });

        step("Кликаем по ссылке репозитория " + REPO_LINK, () -> {
            searchPage.repoLinkClick();
        });

        step("Нажимаем на Issues", () -> {
            repoPage.issueTabClick();
        });

        step("Проверяем issue " + ISSUE_NAME, () -> {
            repoPage.checkIssueTitle(ISSUE_NAME);
        });
    }

    @Test
    @DisplayName("test with @Step")
    public void checkNameIssueAnnotationStep() {

        StepsWeb webSteps = new StepsWeb();

        webSteps.openMainPage();
        webSteps.searchRepo(REPO_LINK);
        webSteps.clickOnLinkRepo();
        webSteps.clickIssueTab();
        webSteps.checkIssueTitle(ISSUE_NAME);
    }

}
