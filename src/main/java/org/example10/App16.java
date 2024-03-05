package org.example10;

import java.io.FileWriter;
import java.io.IOException;

// nested try catch
public class App16 {
    public static void main(String[] args) {
        m1();
        System.out.println("main complete");
    }

    public static void m1(){



        int x = 10;
        int y = 0;

        try{
            System.out.println("try-1");
            int z = x / y;

        }
        catch (RuntimeException e){
            System.out.println("catch - 1");
            try{
                System.out.println("try-2");
                int z = x / y;

            }
            catch (RuntimeException e1){
                System.out.println("catch - 2");

            }
            finally {
                System.out.println("finally-2");
            }
        }
        finally {
            System.out.println("finally-1");
        }

    }
}
