package org.example3.models;

public class Appliance {

    private String id;
    private String name;
    private String manufacturer;
    private Float price;

    public Appliance(String id, String name, String manufacturer, Float price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Float getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }
}
