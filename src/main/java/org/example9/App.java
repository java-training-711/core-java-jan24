package org.example9;

import java.time.Instant;

public class App {

//    dasdadasdadasddfsfsfsfsf

    // same process and threads share the address and memory space of process
    // save (thread1)
    // blinking (thread2)

    public static void main(String[] args) {
        String[] names = {"JOHN", "ALEX", "JACOB", "DAVID", "JACKSON"};

        long startTime = Instant.now().getNano();

        for(String name: names){

            int sum = 0;
            for(char c: name.toCharArray()){
                sum = sum + (int)c;
                System.out.println(c + ""+ (int)c);
            }

            System.out.println(name+ ":"+ sum);
        }

        long timeTaken = Instant.now().getNano() - startTime;
        System.out.println(timeTaken);
    }

}
