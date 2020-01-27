package page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends FluentPage {

    @Page
    SearchResultPage searchResultPage;

    @FindBy(id = "txtSearch")
    private FluentWebElement searchBarInput;

    @FindBy(css = "#cmdSearch")
    private FluentWebElement searchLoupe;

    public void fillDescriptionInFindBarAndPerformSearch(String description) {
        searchBarInput.fill().withText(description);
        searchLoupe.click();
    }

}
