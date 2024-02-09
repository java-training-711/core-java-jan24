package org.example4.cache;

public class CacheManager {
    public static void main(String[] args) {
        CacheProvider provider = new DiskCache();
//        provider.put("K1", "V1");
//        provider.put("K2", "V2");
//        provider.put("K3", "V3");

        System.out.println(provider.get("K1"));
        System.out.println(provider.get("K2"));
        System.out.println(provider.get("K3"));

        provider = new InMemoryCache();
      //  provider.put("K1", "V1");
        System.out.println(provider.get("K1"));

    }
}
