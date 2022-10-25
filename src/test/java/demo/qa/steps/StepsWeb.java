package demo.qa.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsWeb {


    @Step("Open main page")
    public void openMainPage() {
        open("/");
    }

    @Step("Search repository")
    public void searchRepo(String repoName) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repoName);
        $(".header-search-input").submit();
        }

    @Step("Click on repository")
    public void clickOnLinkRepo() {
        $(linkText("Azaze1o/HW_8")).click();

    }

    @Step("Click on issue")
    public void clickIssueTab() {
        $("#issues-tab").click();

    }

    @Step("Check issue")
    public void checkIssueTitle(String issueTitle) {
        $("#issue_1_link").shouldHave(Condition.text(issueTitle));
    }


    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
