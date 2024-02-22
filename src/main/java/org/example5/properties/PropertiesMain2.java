package org.example5.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesMain2 {

    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.home"));
        // config.properties should be copied to user.home. run the application once to get user.home
        String configFilePath = System.getProperty("user.home")+"/config.properties";
        Properties props = new Properties(); // hashtable
        props.put("username","abc@email.com");
        props.put("password","password1");
        System.out.println(props);

        InputStream is = new FileInputStream(configFilePath);
        Properties configProps = new Properties();
        configProps.load(is);
        is.close();

        System.out.println(configProps);

        props.putAll(configProps);

        System.out.println(props);
    }
}
