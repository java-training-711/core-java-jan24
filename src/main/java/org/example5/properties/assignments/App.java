package org.example5.properties.assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.home")); //user home is C:\Users\konki
//        String configFilePath = System.getProperty("user.home")+"/code/task/core-java-jan24/src/main/resources/config.properties";
        String configFilePath = System.getProperty("user.home")+"/config.properties";
        System.out.println(configFilePath);
        Properties props = new Properties();
        props.put("name", "Jason");
        props.put("name1", "Josh");
        props.put("name2", "Gary"); //why is it printing only 1 set

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
