import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ItemHelper extends HelperBase {
    public ItemHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createNewItem(Item item) {
        driver.findElement(By.cssSelector(".btn-outline-warning")).click();
        WebElement button =  driver.findElement(By.cssSelector("a[href='create']"));
        button.click();
        driver.findElement(By.id("id_brand")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_brand"));
            dropdown.findElement(By.xpath("//option[. = 'ITIS Models']")).click();
        }
        driver.findElement(By.id("id_brand")).click();
        driver.findElement(By.id("id_name")).click();
        driver.findElement(By.id("id_name")).sendKeys(item.getName());
        driver.findElement(By.id("id_added_by")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_added_by"));
            dropdown.findElement(By.xpath("//option[. = 'test']")).click();
        }
        driver.findElement(By.id("id_added_by")).click();
        driver.findElement(By.id("id_colour")).click();
        driver.findElement(By.id("id_colour")).sendKeys(item.getColour());
        driver.findElement(By.id("id_price")).click();
        driver.findElement(By.id("id_price")).sendKeys(item.getPrice());
        driver.findElement(By.id("id_season")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_season"));
            dropdown.findElement(By.xpath("//option[. = 'spring']")).click();
        }
        driver.findElement(By.id("id_season")).click();
        driver.findElement(By.cssSelector("button")).click();
    }
    public Item getCreatedItem(){
        String name = driver.findElement(By.cssSelector(".container:last-of-type")).findElement(By.tagName("h5")).getText();
        return new Item(name, "", "");
    }
    public Item getLastItem(){
        String name = driver.findElement(By.cssSelector(".container:last-of-type")).findElement(By.tagName("h5")).getText();
        return new Item(name, "", "");
    }
    public void deleteItem(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".container")).findElement(By.cssSelector("a:last-of-type")).click();

        driver.findElement(By.cssSelector("[type='Submit'")).click();
    }
}
