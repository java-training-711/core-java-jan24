package org.example10;

import java.util.Arrays;

public class App14 {
    public static void main(String[] args) {
        m1(-1); // due to exception here below line wont be executed
        System.out.println("main complete");
    }

    public static void m1(int key){
        int[] arr = {10,11};
        try {
            System.out.println("in try block");
            if(key == 2) {
                System.out.println(arr[2]);
            }
            if(key == 0){
                int result = 2 / key;
            }
            if(key == -1){
                throw new IllegalArgumentException("parameter is not valid");
            }
        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException e){ // parent can handle child exceptions
            System.out.println(e);
            if(e instanceof ArithmeticException){
                System.out.println("denum should not be zero in a division");
            }

            if(e instanceof ArrayIndexOutOfBoundsException){
                System.out.println("array index is not valid");
            }
        }
        catch(RuntimeException e){
            System.out.println(e);
            System.out.println("other exception");
            e.printStackTrace();
        }
        finally {
            Arrays.fill(arr, 0);
            System.out.println("arrays filled in finally");
        }
       // System.out.println(Arrays.toString(arr));
    }
}
