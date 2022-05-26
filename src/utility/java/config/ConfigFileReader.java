package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private static String fileName = "Configuration.properties";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String filepath = System.getProperty("user.dir")+fileSeperator+"src"+fileSeperator+"utility" +fileSeperator+ "java"+fileSeperator+"config";
    private static String fileLocation =  filepath +fileSeperator+ fileName;


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + fileLocation);
        }
    }

    public String getUserName() {
        String userName = properties.getProperty("username");
        if (userName != null) return userName;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getBaseUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) return browser;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getEnv() {
        String env = properties.getProperty("env");
        if (env != null) return env;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
}
