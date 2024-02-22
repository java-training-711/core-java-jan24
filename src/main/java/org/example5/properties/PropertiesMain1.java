package org.example5.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public class PropertiesMain1 {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties(); // hashtable
        props.put("username","abc@email.com");
        props.put("password","password1");
        System.out.println(props);

        InputStream is = PropertiesMain1.class.getClassLoader().getResourceAsStream("config.properties");
        Properties configProps = new Properties();
        configProps.load(is);
        is.close();

        System.out.println(configProps);

        props.putAll(configProps);

        System.out.println(props);
    }
}
