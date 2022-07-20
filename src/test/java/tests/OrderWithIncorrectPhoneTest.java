package tests;

import org.junit.Test;
import pages.BasketPage;
import pages.HomePage;
import pages.ProductPage;
import pages.WearPage;

public class OrderWithIncorrectPhoneTest extends BaseTest {

    @Test()
    public void orderWithIncorrectPhoneTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToWear();

        WearPage wearPage = new WearPage();
        wearPage.clickStoreProduct("ФУТБОЛКА ПОЛО ЧЕРНАЯ (М)");
        ProductPage productPage = new ProductPage();
        productPage.clickAddToBasketButton();
        BasketPage basketPage = new BasketPage();
        basketPage.sendName("Тестов Тест Тестович")
                .sendPhone("0000000000")
                .sendRegion("Тест")
                .sendAddress("Тест Тестовая 1")
                .sendReceiverName("Тестов Тест Тестович")
                .sendStreet("пр-кт Ленина")
                .sendHouse("1")
                .sendOffice("1")
                .clickOrderButton();
        basketPage.checkPhoneErrorText("Укажите, пожалуйста, корректный номер телефона");
        basketPage.checkMainErrorText("Укажите, пожалуйста, корректный номер телефона");



    }
}
