package org.example10;

// user defined checked exception
// invoked method has checked exception in its signature
public class App20 {
    private static class DataValidationException extends Exception{
        public DataValidationException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            m1();
        } catch (DataValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main1(String[] args) throws DataValidationException {
     m1();
    }

    private static void m1() throws DataValidationException {
        int x = 9;
        if(x < 10){
            throw new DataValidationException("x should not be less than 10");
        }
    }
}
