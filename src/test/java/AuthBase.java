import org.junit.Before;
import java.util.logging.Logger;

import java.io.IOException;

public class AuthBase extends TestBase {
    @Before
    public void setUp() {
        super.setUp();
        try {
            AccountData user = new AccountData(Settings.getStaticSettings().getUsername(), Settings.getStaticSettings().getPassword());
            app.auth.login(user);
            Logger.getAnonymousLogger().info("Logged as "+user.getUsername());
        } catch (Exception e) {
            Logger.getAnonymousLogger().info("Cannot login");
        }

    }
}
