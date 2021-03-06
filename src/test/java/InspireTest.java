// Generated by Selenium IDE
import org.junit.*;

public class InspireTest extends AuthBase {

  @Test
  public void createWork() {
    app.navigation.openHomePage();
    app.navigation.openItemsPage();
    Item item = new Item("testcase last 92", "cyan", "1000");
    app.item.createNewItem(item);
    Item newItem = app.item.getCreatedItem();
    Assert.assertEquals(item.name, newItem.name);
  }
  @Test
  public void createItem() {
    app.navigation.openWorksPage();
    Work work = new Work("my latest work", "okay");
    app.work.createNewWork(work);
    Work newWork = app.work.getCreatedWork();
    Assert.assertEquals(work.getTitle(),newWork.getTitle());
  }

  @Test
  public void deleteItem(){
    app.navigation.openItemsPage();
    Item deleted = app.item.getLastItem();
    app.navigation.openLastItemPage();
    app.item.deleteItem();
    app.navigation.openItemsPage();
    Item last = app.item.getLastItem();
    app.finalize();
  }
}
