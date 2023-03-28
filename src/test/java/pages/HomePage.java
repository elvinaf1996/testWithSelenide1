package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.config;

public class HomePage {

    private final By CITY = By.xpath("//input[@placeholder='Куда вы хотите поехать?']");
    private final By FIND_BUTTON = By.xpath("//button[@type='submit']");
    private final By ACCEPT_COOKIES_BUTTON = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private final By DROP_DOWN_LIST_ITEMS = By.xpath("//div[@class='a40619bfbe']");

    public HomePage openPage() {
        open(config.baseUrl());
        return this;
    }

    public HomePage acceptCookies() {
        $(ACCEPT_COOKIES_BUTTON).click();
        return this;
    }

    public HomePage findByCity(String cityName) {
        $(CITY).sendKeys(cityName);
        $$(DROP_DOWN_LIST_ITEMS).get(0).shouldHave(Condition.text(cityName));
        $(FIND_BUTTON).click();
        return this;
    }
}