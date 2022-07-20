package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    private final By ADD_TO_Basket_BUTTON = By.cssSelector(".js-store-prod-popup-buy-btn-txt");

    public ProductPage clickAddToBasketButton() {
        $(ADD_TO_Basket_BUTTON).click();
        return this;
    }
}
