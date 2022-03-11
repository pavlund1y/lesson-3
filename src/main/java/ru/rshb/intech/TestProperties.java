package ru.rshb.intech;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private final Properties properties = new Properties();

    private static TestProperties instance;

    public static TestProperties getInstance() {
        if(instance == null) {
            instance = new TestProperties();
        }
        return instance;
    }

    private TestProperties() {

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return (String) properties.get(key);
    }


}
