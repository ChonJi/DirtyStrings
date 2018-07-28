package selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static selectors.Locator.id;
import static selectors.Locator.xpath;
import static com.codeborne.selenide.Selenide.$;

public class Selector {

    private WebElement element;

    public WebElement selectElement(Locator locator, String s) {

        if (locator.equals(id)) {
            element = $(By.id(s));
        } else if (locator.equals(xpath)) {
            element = $(By.xpath(s));
        } else {
            element = $(By.cssSelector(s));
        }

        return element;

    }

}
