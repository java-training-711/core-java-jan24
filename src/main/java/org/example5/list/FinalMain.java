package org.example5.list;

// final class: cant extend class, so cant override method
// final method: cant override(non static public protected) method
// final variable non-static: re-initialize of variable not allowed. you can initialize only once in-place or through constructor
// final variable static: re-initialize of variable not allowed. you can initialize only once in-place (not using constructor because we cant access static variable using this keyword)
// final variable as method parameter: re-initialize not allowed
public class FinalMain {
    public static void main(String[] args) {

    }

    private static class A2{

        private int x;
        private int y;

        public A2(final int x, final int y) {
//            x++;
//            y++;
            this.x = x;
            this.y = y;
        }


        public void m1(final int z){
//            z++;
            int xx = z;
            xx++;

            final int yy = 10;
//            yy = 11;
        }
    }

    private
//    final
    static class A1{
        public void m1(){
        }

        public void m2(){
        }
    }

    // when A1 is final , then it can be extended by B1
    private static class B1 extends A1{
        @Override
        public void m1() {
            super.m1();
        }

        @Override
        public void m2() {
            super.m2();
        }
    }
    private static class A{

        private static final int x=10;
        private final int y;
        private static final int k = 0; // only in-place initialization
        private int z;

        public A(int y) {
            this.y = y;
        }

        public void m1(){
          //  x++; // x = x+1
            z++;
        }

        final public void m2(){
         //   x--; // x = x-1
        }
    }

    private static class B extends A{
        public B(int y) {
            super(y);
        }

        @Override
        public void m1() {
            super.m1();
        }

//        @Override
//        public void m2() {
//            super.m2();
//        }
    }
}
