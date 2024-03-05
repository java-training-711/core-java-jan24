package org.example10;

// user defined checked exception
public class App18 {
    private static class DataValidationException extends Exception{
        public DataValidationException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws DataValidationException{
        int x = 9;
        if(x < 10){
            throw new DataValidationException("x should not be less than 10");
        }
    }
}
