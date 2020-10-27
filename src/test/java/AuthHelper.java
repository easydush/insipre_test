import org.openqa.selenium.By;

public class AuthHelper  extends HelperBase{
    public AuthHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(AccountData user) {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("id_username")).sendKeys(user.getUsername());
        driver.findElement(By.id("id_password")).click();
        driver.findElement(By.id("id_password")).sendKeys(user.getPassword());
    }

}
