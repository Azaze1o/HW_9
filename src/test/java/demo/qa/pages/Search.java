package demo.qa.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.SelenideElement;

public class Search {

    private static final String REPO_LINK = "Azaze1o/HW_8";

    private final SelenideElement repoLink = $(linkText(REPO_LINK));

    public Search repoLinkClick() {

        repoLink.click();
        return this;
    }

}
