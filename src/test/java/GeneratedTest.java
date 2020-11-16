import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.junit.*;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GeneratedTest extends AuthBase {
    @Test
    public void createGeneratedItem() throws IOException, JsonException {
        app.navigation.openItemsPage();
        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get("items.json"));

        // create parser
        JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

        // read items
        JsonArray items = (JsonArray) parser.get("items");
        items.forEach(entry -> {
            JsonObject json = (JsonObject) entry;
            Item item = new Item((String) json.get("name"),(String) json.get("colour"),json.get("price").toString());
            app.item.createNewItem(item);
        });
        //close reader
        reader.close();
    }
}
