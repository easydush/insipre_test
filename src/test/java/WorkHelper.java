import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WorkHelper extends HelperBase{

    public WorkHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createNewWork(Work work){
        driver.findElement(By.linkText("Add new work")).click();
        driver.findElement(By.id("id_title")).click();
        driver.findElement(By.id("id_title")).sendKeys(work.getTitle());
        driver.findElement(By.id("id_style")).click();
        driver.findElement(By.id("id_style")).sendKeys(work.getStyle());
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
        WebElement button =  driver.findElement(By.cssSelector(".btn-primary"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                , button);
        button.click();
    }
    public Work getCreatedWork(){
        String name = driver.findElement(By.cssSelector(".container:last-of-type")).findElement(By.tagName("h5")).getText();
        return new Work(name, "");
    }

}
