import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InvalidLoginTest extends TestBase{
    @Test
    public void loginWithInvalidPassword() throws IOException, JsonException {
        AccountData user = new AccountData("test", "Iamtesti1");
        app.navigation.openHomePage();
        app.auth.login(user);
        Assert.assertFalse(app.auth.isLoggedIn());
    }
    @Test
    public void loginWithInvalidUser() throws IOException, JsonException {
        AccountData user = new AccountData("tester", "Iamtesting!1");
        app.navigation.openHomePage();
        app.auth.login(user);
        Assert.assertFalse(app.auth.isLoggedIn(user.getUsername()));
    }
    @Test
    public void loginWithWalidData() throws IOException, JsonException {
        Settings settings = Settings.getStaticSettings();
        AccountData user = new AccountData(settings.getUsername(), settings.getPassword());
        app.auth.login(user);
        Assert.assertTrue(app.auth.isLoggedIn(settings.getUsername()));
    }
}
