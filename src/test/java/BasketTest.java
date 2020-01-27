import engine.CustomFluentDriver;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import org.junit.Test;
import page.CartPage;
import page.DetailedProductPage;
import page.MainPage;

import static org.junit.Assert.assertEquals;

public class BasketTest extends CustomFluentDriver {

    @Page
    MainPage mainPage;

    @Page
    DetailedProductPage detailedProductPage;

    @Page
    CartPage cartPage;

    @Test
    public void shouldAddItemToBasketAndCheckThatIsProperlyCalculated() {
        goTo(mainPage).openFirstProductFromTheList().verifyThatProductPageHasBeenLoaded();
        String actualPrice = detailedProductPage.getProductPrice();
        String actualName = detailedProductPage.getProductName();
        detailedProductPage
                .selectSize()
                .addProductToBasket();
        goTo(mainPage).viewBag();
        String expectedPrice = cartPage.getTotalPrice();
        String expectedName = cartPage.getProductDescription();
        assertEquals(expectedName, actualName);
        assertEquals(expectedPrice, actualPrice);
    }

}
