package org.example10;

// user defined unchecked exception
public class App17 {
    private static class DataValidationException extends RuntimeException{
        public DataValidationException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        int x = 9;
        if(x < 10){
            throw new DataValidationException("x should not be less than 10");
        }
    }
}
