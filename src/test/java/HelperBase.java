import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class HelperBase {
    public WebDriver driver;
    ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.driver;
    }

}
