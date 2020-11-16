import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        if (type.equals("items")) {
            generateItems(count, filename, format);
        } else {
            System.out.println("Unrecognized type of data" + type);
        }
    }

    public static void generateItems(int count, String filename, String format) {

        try {
            // create a writer
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename + "." + format));
            JsonObject items = new JsonObject();
            List<JsonObject> newItems = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                // create item object
                JsonObject item = new JsonObject();

                Random random = new Random();
                item.put("name", java.util.UUID.randomUUID().toString());
                item.put("colour", java.util.UUID.randomUUID().toString());
                item.put("price", random.nextInt(10000));
                newItems.add(item);
            }
            items.put("items", newItems);
            // write JSON to file
            Jsoner.serialize(items, writer);
            //close the writer
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
