package org.example4.cache;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DiskCache implements CacheProvider{
    private Map<String, String> map;

    public DiskCache() {
        try {
            readFromDisk();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void put(String key, String value) {
        map.put(key, value);
        // write object map to disk using serialization
        try {
            writeToDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }

    private void writeToDisk() throws IOException {
        System.out.println("writing data to disk");
        File file = new File("data.cache");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.map);
    }

    private void readFromDisk() throws IOException, ClassNotFoundException {
        File file = new File("data.cache");
        if(!file.exists()){
            System.out.println("no file found in disk. init with empty map");
            this.map = new HashMap<>();
            return;
        }
        System.out.println("loading past data from disk");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.map = (Map<String, String>) ois.readObject();
    }
}
