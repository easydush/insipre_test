import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    public WebDriver driver;
    public Map<String, Object> vars;
    public JavascriptExecutor js;
    public static ThreadLocal<ApplicationManager> app = new ThreadLocal<>();
    public NavigationHelper navigation;
    public AuthHelper auth;
    public ItemHelper item;
    public WorkHelper work;
    public String baseUrl;

    public WebDriver getDriver() {
        return driver;
    }

    public Map<String, Object> getVars() {
        return vars;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public AuthHelper getAuth() {
        return auth;
    }

    public ItemHelper getItem() {
        return item;
    }

    public WorkHelper getWork() {
        return work;
    }

    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        baseUrl = "http://easybreezy.pythonanywhere.com/about/";
        navigation = new NavigationHelper(this);
        AccountData user = new AccountData("test","Iamtesting!1" );
        navigation.openHomePage();
        auth = new AuthHelper(this);
        auth.login(user);
        item = new ItemHelper(this);
        work = new WorkHelper(this);
    }
    public static ApplicationManager getInstance(){
        if(app.get() == null){
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.navigation.openHomePage();
            app.set(newInstance);
        }
        return app.get();
    }
    public void stop(){
        driver.quit();
    }

    @Override
    protected void finalize(){
        try {
            driver.quit();
        }
        catch (Exception ignored){}
    }
}
