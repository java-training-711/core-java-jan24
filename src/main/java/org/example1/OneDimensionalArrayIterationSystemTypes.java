package org.example1;

public class OneDimensionalArrayIterationSystemTypes {

    public static void main(String[] args) {
        String[] names = {"JOHN", "ALEX"};
        // for each elem in names array where elem type is String
        for(String elem: names){
            System.out.println(elem);
        }

        // for index
        for(int i=0; i < names.length; i++){
            System.out.println(names[i]);
        }

        for(int i= names.length - 1; i >=0; i--){
            System.out.println(names[i]);
        }

        // while loop
        int index = 0;
        while(index < names.length){
            System.out.println(names[index]);
            index++;
        }

        index = 0;
        while(true){
            if(index == names.length){
                break;
            }
            System.out.println(names[index]);
            index++;
        }
    }
}
