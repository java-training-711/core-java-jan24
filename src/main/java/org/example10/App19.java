package org.example10;

// user defined checked exception
public class App19 {
    private static class DataValidationException extends Exception{
        public DataValidationException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        int x = 9;
        if(x < 10){
            try {
                throw new DataValidationException("x should not be less than 10");
            } catch (DataValidationException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
