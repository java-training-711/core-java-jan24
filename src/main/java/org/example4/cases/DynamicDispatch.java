package org.example4.cases;

public class DynamicDispatch {

    private interface Shape{
        public Float area();
    }

    private static class Rectangle implements Shape{

        private float length;
        private float breadth;

        public Rectangle(float length, float breadth) {
            this.length = length;
            this.breadth = breadth;
        }

        @Override
        public Float area() {
            return length * breadth;
        }
    }

    private static class Square implements Shape{
        private float length;

        public Square(float length) {
            this.length = length;
        }

        @Override
        public Float area() {
            return length * length;
        }
    }

    private static class Circle implements Shape{

        private float radius;

        public Circle(float radius) {
            this.radius = radius;
        }

        @Override
        public Float area() {
           Double area = (Math.PI * radius * radius);
           return area.floatValue();
        }
    }

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 20);
        Shape square = new Square(10);
        Shape circle = new Circle(7);

        Shape[] shapes = {rectangle, square, circle};

        int i = 0;
        while(true){
            if(i == shapes.length){ // 2 == 2
                break;
               // return;
            }
            Shape currentShape = shapes[i];
            System.out.println(currentShape.area());
            i++;
        }
        System.out.println("area calculated");
    }
}
