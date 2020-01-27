package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends FluentPage {

    @FindBy(css = ".productTitle")
    private FluentList<FluentWebElement> productDescriptions;

    @FindBy(id = "TotalValue")
    private FluentWebElement totalValue;


    public String getTotalPrice() {
        await().until(totalValue).present();
        return totalValue.text();
    }

    public String getProductDescription() {
        await().until(productDescriptions).present();
        return productDescriptions.stream().findFirst().get().text();
    }

}
