import engine.CustomFluentDriver;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import page.MainPage;
import page.NavigationBar;
import page.SearchResultPage;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static page.MainPage.productDescription;

public class SearchItemTest extends CustomFluentDriver {

    @Page
    MainPage mainPage;

    @Page
    NavigationBar navigationBar;

    @Page
    SearchResultPage searchResultPage;

    @Test
    public void shouldFindItemThatExistsOnProductList() {
        goTo(mainPage).getDescriptionOfTheFirstProductFromTheList();
        String description = productDescription.stream().findFirst().get();
        navigationBar.fillDescriptionInFindBarAndPerformSearch(description);
        searchResultPage.verifyThatProductHasBeenFound();
    }

    @Test
    public void shouldNotFindItemThatDoesNotExists() {
        String itemRandomName = randomAlphabetic(10);
        goTo(mainPage);
        navigationBar.fillDescriptionInFindBarAndPerformSearch(itemRandomName);
        searchResultPage.verifyThatProductHasNotBeenFound();
    }

}
