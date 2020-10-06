package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private static ReadProperties instance = null;
    private Properties properties;

    private ReadProperties() {
        this.properties = new Properties();
        readConfig();
    }

    public static ReadProperties getInstance() {

        if (instance == null) {
            instance = new ReadProperties();
        }

        return instance;
    }

    private void readConfig() {

        try (FileReader reader = new FileReader("src/test/resources/config.properties")) {
            properties.load(reader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public Properties getProperties() {
        return properties;
    }
}
