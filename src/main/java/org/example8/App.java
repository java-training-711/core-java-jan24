package org.example8;

import java.util.Arrays;
import java.util.Comparator;

public class App {


    private static class AddressTypeComparator implements Comparator<AddressType>{
        @Override
        public int compare(AddressType o1, AddressType o2) {
            return Integer.compare(o1.getValue(), o2.getValue());
        }
    }
    // enums used as constants
    // each of them initialize only once
    // using parameter enum we can have custom comparison logic
    private enum AddressType // extends Enum
             {


        HOME(10){
            @Override
            public void availability() {
                System.out.println(this.getValue()+ "  24 hrs");
            }
        },
        OFFICE(11){
            @Override
            public void availability() {
                System.out.println(this.getValue()+ " 9 to 6");
            }
        };

        private int value;

        AddressType(int value){
            System.out.println(this);
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public abstract void availability();
    }

    public static void main(String[] args) {
        System.out.println(AddressType.OFFICE.getValue());
        System.out.println(AddressType.OFFICE.getValue());
        System.out.println(AddressType.class);


        AddressType.HOME.availability();
        AddressType.OFFICE.availability();

        int result = new AddressTypeComparator().compare(AddressType.OFFICE, AddressType.HOME);
        System.out.println(result);

        AddressType[] addressTypes= AddressType.values();
        Arrays
                .stream(addressTypes)
                .forEach(item->{
            System.out.println(item+": "+item.ordinal()+":"+item.name()
            );
        });
    }
}
