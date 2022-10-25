package demo.qa.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;

public class Main {

    private final SelenideElement searchInput = $(".header-search-input");

    public Main openPage() {

        open("/");

        return this;
    }

    public Main searchInputClick() {

        searchInput.click();
        return this;
    }

    public Main searchInputSetValue(String repoName) {

        searchInput.setValue(repoName);
        return this;
    }

    public Main searchInputSubmit() {

        searchInput.submit();
        return this;
    }

}
