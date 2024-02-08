package org.example3.models;

import java.util.UUID;

// 100 rs off on every washing machine
public class WashingMachine extends Appliance {

    private String type;
    private String digital;

    public WashingMachine(String type, String digital, Float price) {
       // super(); // super should be first line constructor
        super(UUID.randomUUID().toString(),"Washing Machine","LG", price);
        this.type = type;
        this.digital = digital;
    }

    @Override
    public Float getPrice() {
        return super.getPrice() - 100f;
    }

    @Override
    public String toString() {
        return "WashingMachine{" +
                "type='" + type + '\'' +
                ", digital='" + digital + '\'' +
                '}' + super.toString();
    }
}
