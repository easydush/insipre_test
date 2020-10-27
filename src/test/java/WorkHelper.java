import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WorkHelper extends HelperBase{

    public WorkHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createNewWork(Work work){
        driver.findElement(By.linkText("Add new work")).click();
        driver.findElement(By.id("id_title")).click();
        driver.findElement(By.id("id_title")).sendKeys(work.getTitle());
        {
            WebElement dropdown = driver.findElement(By.id("id_photos"));
            dropdown.findElement(By.xpath("//option[. = 'Pickachu easybreezy']")).click();
        }
        {
            WebElement dropdown = driver.findElement(By.id("id_items"));
            dropdown.findElement(By.xpath("//option[. = 'Laptop']")).click();
        }
        driver.findElement(By.id("id_stowner")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_stowner"));
            dropdown.findElement(By.xpath("//option[. = 'isis']")).click();
        }
        driver.findElement(By.id("id_stowner")).click();
        driver.findElement(By.id("id_style")).click();
        driver.findElement(By.id("id_style")).sendKeys(work.getStyle());
    }

}
