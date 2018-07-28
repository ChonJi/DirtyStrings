package doomLibraries;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import selectors.Locator;
import selectors.Selector;

import static com.codeborne.selenide.WebDriverRunner.url;

public class DoomExecutor {

    private Selector select = new Selector();

    private void setUp(String url) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        Selenide.open(url);
        Assertions.assertEquals(url, url());
    }

    public void executeDoom(String url, Locator locator, String path) {

        setUp(url);
        for (String s : JsonReader.dirtyStringsList) {
            final WebElement element = select.selectElement(locator, path);
            element.clear();
            element.sendKeys(s);
            element.sendKeys(Keys.ENTER);
        }
    }

    public void executeDoom(String url, Locator locator, Locator locator2, String path, String path2) {
        int i = JsonReader.dirtyStringsList.size();

        setUp(url);
        for (String s : JsonReader.dirtyStringsList) {

            select.selectElement(locator, path).clear();
            select.selectElement(locator2, path2).clear();
            select.selectElement(locator, path).sendKeys(s);
            select.selectElement(locator2, path2).sendKeys(JsonReader.dirtyStringsList.get(i));
            i--;
        }
    }

}
