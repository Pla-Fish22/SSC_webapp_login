package io.muzoo.ooc.webapp.basic.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {

    public static ConfigProperties load() {
        try (FileInputStream fin = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(fin);
            String user = prop.getProperty("database.username");
            String password = prop.getProperty("database.password");
            String driver = prop.getProperty("database.driverClassName");
            String jdbcUrl = prop.getProperty("database.connectionUrl");


            return new ConfigProperties.ConfigPropertiesBuilder().databaseUser(user)
            .databasePassword(password)
            .databaseDriver(driver)
            .databaseConnectionUrl(jdbcUrl)
            .build();
        } catch (Exception e) {
            System.out.println("Exception " + e);
            return null;
        }

    }


}
