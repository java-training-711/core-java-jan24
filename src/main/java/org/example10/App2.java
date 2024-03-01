package org.example10;

public class App2 {

    // Exception, Error
    // Throwable
    // Exception
          // ClassNotFoundException, InterruptedException, IOException
          // RuntimeException
               // IndexOutofBoundException, ArithmaticException,

    // unchecked exception: RuntimeException or its child
    // checked exception: Exception or its child but not RuntimeException and its child.
          // can be detected during compile time of code
          // can be used as throws with method signature
    // checked or unchecked: both of them occur during runtime execution of code only. they can be wrapped by try / catch

    public static void main(String[] args) throws ClassNotFoundException {
      //  Thread.sleep(2000);
        //m1();
        m2();
    }

    private static void m1() throws ClassNotFoundException {
        Class.forName(IndexCounter.class.getName());
        Class.forName("com.app.A");
    }

    private static void m2(){
        try {
            m1();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static class IndexCounter{
        private int count = 0;
        static {
            System.out.println("sb: 1");
        }
    }
}
