package org.example3.models;

// POJO : Plain Old java Object
// you dont need any external library to compile this class.

// lombok
public class Item {

    private String id;
    private String name;
    private Float price;

    /**
     * dont define any constructor, by default we get the 0 param constructor
     *
     * do define only param constructor, then by default 0 param constructor wont be added
     */
    public Item() { // default constructor
    }

    // used to initialize the state of object after teh object has been created
    public Item(String id, String name, Float price) { // param constructor
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
