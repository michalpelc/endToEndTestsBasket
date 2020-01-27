import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import page.CartPage;
import page.DetailedProductPage;
import page.MainPage;

public class BasketTest {

    @Page
    MainPage mainPage;

    @Page
    DetailedProductPage detailedProductPage;

    @Page
    CartPage cartPage;

    @Test
    public void shouldAddItemToBasketAndCheckThatIsProperlyCalculated(){

    }

}
