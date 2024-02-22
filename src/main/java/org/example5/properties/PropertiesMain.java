package org.example5.properties;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public class PropertiesMain {

    public static void main(String[] args) {
        Properties props = new Properties(); // hashtable
        props.put("username","abc@email.com");
        props.put("password","password1");

        System.out.println(props);

        System.out.println(props.getProperty("password"));
        System.out.println(props.getProperty("url", "localhost:3306"));


        for(Object key: props.keySet()){
            System.out.println(key+" "+props.getProperty(key.toString()));
        }

        Enumeration<Object> keys = props.keys();
        while(keys.hasMoreElements()){
            Object key = keys.nextElement();
            System.out.println(key+" "+props.getProperty(key.toString()));
        }

        for(Map.Entry entry: props.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        Enumeration<Object> elements = props.elements(); // only values
        while(elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
    }
}
