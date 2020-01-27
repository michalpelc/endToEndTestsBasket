package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends FluentPage {

    @FindBy(css = ".productTitle")
    private FluentList<FluentWebElement> productDescriptions;

    @FindBy(css = ".prodelete")
    private FluentList<FluentWebElement> removeSign;

    @FindBy(id = "TotalValue")
    private FluentWebElement totalValue;

    @FindBy(css = ".BasketQuantBut.s-basket-plus-button")
    private FluentList<FluentWebElement> addProductSigns;

    @FindBy(css = ".UpdateSurround .NewUpdateQuant")
    private FluentWebElement updateBagSign;

}
