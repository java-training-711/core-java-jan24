package org.example1;

public class ArrayRecursion {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        // index increase to its length - 1
        recursiveWith_1d_Array(arr, 0);
//        recursiveWith_1d_Array(arr, 1);
//        recursiveWith_1d_Array(arr, 2);
    }

    /**
     * stack overflow error
     * 3:  call(arr, 0)
     * 2 : call(arr, 0)
     * 1 : call(arr, 0)
     *
     * index out of bound exception
     * 4:  call(arr, 3)
     * 3:  call(arr, 2)
     * 2 : call(arr, 1)
     * 1 : call(arr, 0)


     * index out of bound exception
     * 4:  call(arr, 3) // return ?? removed from stack
     * 3:  call(arr, 2) // execution is complete, removed from top of stack
     * 2 : call(arr, 1) // execution is complete, removed from top of stack
     * 1 : call(arr, 0) // execution is complete, removed from top of stack
     *
     * @param arr
     * @param index
     */
    private static void recursiveWith_1d_Array(int[] arr, int index){
        if(index == arr.length){
            return;
        }
        System.out.println(arr[index]);
        index = index +1;
        recursiveWith_1d_Array(arr, index);
        System.out.println("done for index: "+index);
    }
}
