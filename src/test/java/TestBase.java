import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    ApplicationManager app;
    @Before
    public void setUp() {
       app = ApplicationManager.getInstance();
       app.navigation.openHomePage();
    }
}
