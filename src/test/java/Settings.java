import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Settings {
    private String username;
    private String password;
    private String baseUrl;
    private static Settings staticSettings;

    public static Settings getStaticSettings() {
        return staticSettings;
    }
    public static void setStaticSettings(Settings staticSettings){
        Settings.staticSettings = staticSettings;
    }
    public Settings(){}
    static {
        // create a reader
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("settings.json"));
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
            Settings settings = new Settings();
            settings.baseUrl = (String) parser.get("baseUrl");
            settings.username = (String) parser.get("username");
            settings.password = (String) parser.get("password");
            setStaticSettings(settings);
        } catch (IOException | JsonException e) {
            Logger.getAnonymousLogger().info("Cannot read file settings.json");
        }

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
