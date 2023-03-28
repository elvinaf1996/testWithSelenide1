package tests;

import org.junit.Test;
import pages.HomePage;
import pages.SearchPage;

public class FirstSelenideTest extends BaseTest {

    @Test()
    public void orderWithIncorrectPhoneTest() {
        String cityName = "Анталья";
        int countStars = 5;

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        homePage.openPage()
                .acceptCookies()
                .findByCity(cityName);
        searchPage.checkLabel(cityName)
                .setStars(countStars)
                .checkThatAllHotelsHaveStars(countStars);
    }
}
