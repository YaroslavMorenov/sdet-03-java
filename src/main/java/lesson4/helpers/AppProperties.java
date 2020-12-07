package lesson4.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties properties;

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    static {
        try {
            fileInputStream = new FileInputStream("application.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch(IOException e) {
            e.printStackTrace();
        } finally{
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
