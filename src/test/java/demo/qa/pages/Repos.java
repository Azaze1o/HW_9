package demo.qa.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class Repos {

    private final SelenideElement issueTab = $("#issues-tab"), issueTitle = $("#issue_1_link");

    public Repos issueTabClick() {

        issueTab.click();
        return this;
    }

    public Repos checkIssueTitle(String name) {

        issueTitle.shouldHave(text(name));
        return this;
    }

}
