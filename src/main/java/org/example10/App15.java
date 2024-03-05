package org.example10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class App15 {
    public static void main(String[] args) {
        m1();
        System.out.println("main complete");
    }

    public static void m1(){


        String path = System.getProperty("user_home");
        String filleName = "file.txt";

        FileWriter writer = null;
        try {
            writer = new FileWriter(path+"/"+filleName);
            writer.write("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally { // finally should be silent , if it throws exception then the previous exceptions wont be thrown or printed or lost
            try {
               if(writer !=null ) writer.close(); // do null check always
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
