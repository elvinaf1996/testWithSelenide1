package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    private final By SEARCH_LABEL = By.xpath("//h1");
    private final By FIVE_STARS_CHECKBOX = By.xpath("//div[@data-filters-item='popular:class=5']//span[@aria-hidden='true']/..");

    private final By LOADING_BOX = By.cssSelector("[data-testid='overlay-card']");
    private final String COUNT_STARS_CHECKBOX = "[data-filters-item='class:class=%s']";
    private final By CHECK_BOX = By.cssSelector(".bbdb949247");
    private final By FIELD_WITH_STARS = By.cssSelector("[data-testid='rating-stars']");
    private final By STAR = By.cssSelector("span");
    private final By DATE_START = By.xpath("//button[@data-testid='date-display-field-start']");

    public SearchPage checkLabel(String label) {
        $(SEARCH_LABEL).shouldHave(Condition.text(label));
        return this;
    }

    public SearchPage setStars(int count) {
        $(String.format(COUNT_STARS_CHECKBOX, count)).$(CHECK_BOX).click();
        waitUntilPageLoaded();
        return this;
    }

    private SearchPage waitUntilPageLoaded() {
        $(LOADING_BOX).shouldBe(visible, Duration.ofSeconds(20)).shouldBe(Condition.not(visible), Duration.ofSeconds(20));
        return this;
    }

    public SearchPage checkThatAllHotelsHaveStars(int countOfStars) {
        ElementsCollection allElements = $$(FIELD_WITH_STARS);
        for (SelenideElement selenideElement : allElements) {
            ElementsCollection allStars = selenideElement.findAll(STAR);
            allStars.shouldHave(CollectionCondition.size(countOfStars));
        }
        return this;
    }
}