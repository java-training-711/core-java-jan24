package org.example7.task;

public class AssignmentDrinkEnum {
    enum Drink {
        COFFEE,
        TEA,
        JUICE;
    }

    public static void main(String[] args) {
        Drink drink = Drink.JUICE;
        System.out.println(drink);
    }
}
