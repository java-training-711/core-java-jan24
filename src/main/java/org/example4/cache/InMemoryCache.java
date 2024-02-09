package org.example4.cache;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCache implements CacheProvider{

    private Map<String, String> map = new HashMap<>();

    @Override
    public void put(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }
}
