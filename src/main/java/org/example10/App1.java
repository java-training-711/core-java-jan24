package org.example10;

public class App1 {

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

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);
    }
}
