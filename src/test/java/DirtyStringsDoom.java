import doomLibraries.DoomExecutor;
import org.junit.jupiter.api.Test;
import selectors.Locator;

public class DirtyStringsDoom extends DoomExecutor {

    private final String MY_URL = "https://www.google.pl/";

    @Test
    public void buildDoom() {
        executeDoom(MY_URL, Locator.id, "lst-ib");
    }

}
