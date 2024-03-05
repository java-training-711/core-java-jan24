package org.example12;

import java.util.StringTokenizer;

public class StringTokenizerExample {

    public static void main(String[] args) {
        // " \t\n\r\f"
        defaultDelimeter();
        defaultDelimeter_1();
        customeDelimeter();

    }

    private static void customeDelimeter() {
        StringTokenizer tokenizer = new StringTokenizer("He,llo World,How!Are you Guys",",!");
        System.out.println(tokenizer.countTokens());

        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
    }
    private static void defaultDelimeter_1() {
        StringTokenizer tokenizer = new StringTokenizer("Hello\nWorld,HowAre\nyou Guys");
        System.out.println(tokenizer.countTokens());

        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
    }
    private static void defaultDelimeter() {
        StringTokenizer tokenizer = new StringTokenizer("Hello World, How Are you Guys");
        System.out.println(tokenizer.countTokens());

        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
    }
}
