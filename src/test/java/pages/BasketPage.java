package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private final By NAME_INPUT = By.cssSelector("#form346904515 [name='Name']");
    private final By PHONE_INPUT = By.cssSelector("#form346904515 [name='tildaspec-phone-part[]']");
    private final By REGION_INPUT = By.cssSelector("#form346904515 [name='Карта региона или страны. Мы добавим её в логотип']");
    private final By ADDRESS_INPUT = By.cssSelector("#form346904515 [name='Адрес для доставки']");
    private final By RECEIVER_NAME_INPUT = By.cssSelector("#form346904515 [name='tildadelivery-userinitials']");
    private final By STREET_INPUT = By.cssSelector("#form346904515 [name='tildadelivery-street']");
    private final By HOUSE_INPUT = By.cssSelector("#form346904515 [name='tildadelivery-house']");
    private final By OFFICE_INPUT = By.cssSelector("#form346904515 [name='tildadelivery-aptoffice']");
    private final By ORDER_BUTTON = By.cssSelector("#form346904515 .t-submit");
    private final By SEARCH_BOX_LIST_ITEM_TEXT = By.cssSelector(".searchbox-list-item.t-text");
    private final By MAIN_ERROR_TEXT = By.cssSelector("#form346904515 .t-form__errorbox-middle .t-form__errorbox-item.js-rule-error.js-rule-error-phone");
    private final By PHONE_ERROR_TEXT = By.cssSelector("[data-input-lid='1496239478607'] .t-input-error");

    public BasketPage sendName(String name) {
        $(NAME_INPUT).sendKeys(name);
        return this;
    }

    public BasketPage sendPhone(String phone) {
        $(PHONE_INPUT).sendKeys(phone);
        return this;
    }

    public BasketPage sendRegion(String region) {
        $(REGION_INPUT).sendKeys(region);
        return this;
    }

    public BasketPage sendAddress(String address) {
        $(ADDRESS_INPUT).sendKeys(address);
        return this;
    }

    public BasketPage sendReceiverName(String receiverName) {
        $(RECEIVER_NAME_INPUT).sendKeys(receiverName);
        return this;
    }

    public BasketPage sendStreet(String street) {
        $(STREET_INPUT).sendKeys(street);
        $(SEARCH_BOX_LIST_ITEM_TEXT).click();
        return this;
    }

    public BasketPage sendHouse(String house) {
        $(HOUSE_INPUT).sendKeys(house);
        $(SEARCH_BOX_LIST_ITEM_TEXT).click();
        return this;
    }

    public BasketPage sendOffice(String office) {
        $(OFFICE_INPUT).sendKeys(office);
        return this;
    }

    public BasketPage clickOrderButton() {
        $(ORDER_BUTTON).click();
        return this;
    }

    public BasketPage checkPhoneErrorText(String phoneErrorText) {
        $(PHONE_ERROR_TEXT).shouldHave(text(phoneErrorText));
        return this;
    }

    public BasketPage checkMainErrorText(String mainErrorText) {
        $(MAIN_ERROR_TEXT).shouldHave(text(mainErrorText));
        return this;
    }
}