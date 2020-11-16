import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;

public class AuthHelper  extends HelperBase{
    public AuthHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(AccountData user) {
        if (isLoggedIn()){
            if (isLoggedIn(user.getUsername())){
                return;
            }
            logout();
        }
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("id_username")).sendKeys(user.getUsername());
        driver.findElement(By.id("id_password")).click();
        driver.findElement(By.id("id_password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    public void logout(){
        driver.findElement(By.linkText("Log out")).click();
    }

    public boolean isLoggedIn(){
        try {
            driver.findElement(By.linkText("Log out"));
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isLoggedIn(String username){
        try {
            driver.findElement(By.linkText("Hello, "+ username));
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

}
