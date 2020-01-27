package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;
import static org.junit.Assert.assertEquals;
import static page.MainPage.productDescription;

public class SearchResultPage extends FluentPage {

    @FindBy(css = "#productlistcontainer span.productdescriptionname")
    private FluentList<FluentWebElement> productDescriptionList;

    @FindBy(css = ".nosearch-para")
    private FluentWebElement searchNotFoundNotification;

    public void verifyThatProductHasBeenFound() {
        await().until(productDescriptionList).displayed();
        FluentWebElement firstProductDescription = productDescriptionList.first();
        String actualDescription = firstProductDescription.text();
        String expectedDescription = productDescription.stream().findFirst().get();
        assertEquals(actualDescription, expectedDescription);
    }

    public void verifyThatProductHasNotBeenFound() {
        await().atMost(2, TimeUnit.SECONDS).until(searchNotFoundNotification).displayed();
        String message = "Your search did not match any of our products. Please try another keyword.";
        assertThat(searchNotFoundNotification).hasText(message);
    }
}
