package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

@PageUrl("https://www.sportsdirect.com/mens/mens-boots")
public class MainPage extends FluentPage {

    @Page
    DetailedProductPage detailedProductPage;

    @Page
    CartPage cartPage;

    @FindBy(css = "#productlistcontainer a.ProductImageList")
    private FluentList<FluentWebElement> productList;

    @FindBy(css = "#productlistcontainer span.productdescriptionname")
    private FluentList<FluentWebElement> productDescriptionList;

    @FindBy(id = "txtSearch")
    private FluentWebElement bagIcon;

    @FindBy(id = "txtSearch")
    private FluentWebElement bagQty;

    public static final ArrayList<String> productDescription = new ArrayList<>();

    public DetailedProductPage openFirstProductFromTheList() {
        await().until(productList).displayed();
        clickIgnoringPopup(productList.first());
        return detailedProductPage;
    }

    public void getDescriptionOfTheFirstProductFromTheList() {
        await().until(productDescriptionList).displayed();
        FluentWebElement firstProductDescription = productDescriptionList.first();
        String description = firstProductDescription.text();
        productDescription.add(description);
    }

    private void clickIgnoringPopup(FluentWebElement element) {
        String jsScript = "arguments[0].click();";
        ((JavascriptExecutor) getDriver()).executeScript(jsScript, element);
    }

    public CartPage viewBag() {
        await().until(bagIcon).displayed();
        bagIcon.click();
        return cartPage;
    }


}
