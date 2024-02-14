package org.example4.cases;

abstract public   class A{
        abstract public void m1();

        public static void m2(){
            System.out.println("m2(): A");
        }

        public void m3(){
            System.out.println("m3(): A");
        }

        private void m4(){
            System.out.println("m4(): A");
        }

        protected void m5(){
            System.out.println("m5(): A");
        }
    }