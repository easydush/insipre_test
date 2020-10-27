import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class NavigationHelper extends HelperBase {
    public String baseUrl;
    public NavigationHelper(ApplicationManager manager) {
        super(manager);
        this.baseUrl = manager.baseUrl;
    }

    public void openHomePage() {
        driver.get(this.baseUrl);
        driver.manage().window().setSize(new Dimension(1536, 824));
    }
    public void openWorksPage(){
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector(".btn-outline-info:nth-child(3)")).click();
    }
    public void openItemsPage() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector(".btn-outline-warning")).click();
    }

}
