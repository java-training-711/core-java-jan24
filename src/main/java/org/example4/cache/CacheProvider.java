package org.example4.cache;

public interface CacheProvider {
    public void put(String key, String value);
    public String get(String key);
}
