import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemHelper extends HelperBase {
    public ItemHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createNewItem(Item item) {
        driver.findElement(By.linkText("Add new item")).click();
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
            dropdown.findElement(By.xpath("//option[. = 'isis']")).click();
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
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
