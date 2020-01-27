package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DetailedProductPage extends FluentPage {

    @FindBy(xpath = "//li[@class='tooltip sizeButtonli ']")
    private FluentList<FluentWebElement> availableSizes;

    @FindBy(css = ".pdpPrice span")
    private FluentWebElement productPrice;

    @FindBy(css = "a.addToBag")
    private FluentWebElement addToBagIcon;

    @FindBy(id = "lblProductName")
    private FluentWebElement productName;

    public String getProductPrice() {
        return productPrice.text();
    }

    public DetailedProductPage addProductToBasket() {
        addToBagIcon.click();
        return this;
    }

    public String getProductName() {
        return productName.text();
    }

    public DetailedProductPage selectSize() {
        int availableSizesSize = availableSizes.size();
        if (availableSizesSize > 0) {
            availableSizes.get(new Random().nextInt(availableSizesSize)).click();
        }
        return this;
    }

    public void verifyThatProductPageHasBeenLoaded() {
        await().atMost(3, SECONDS).until(productPrice).displayed();
        await().atMost(3, SECONDS).until(productName).displayed();
    }

}
