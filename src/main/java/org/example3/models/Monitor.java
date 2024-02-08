package org.example3.models;

import java.util.UUID;

public class Monitor extends Appliance {

    private int size;
    private String display;

    public Monitor(Float price, int size, String display) {
        super(UUID.randomUUID().toString(), "Monitor", "SAMSUNG", price);
        this.size = size;
        this.display = display;
    }


    @Override
    public String toString() {
        return "Monitor{" +
                "size=" + size +
                ", display='" + display + '\'' +
                '}' + super.toString();
    }
}
