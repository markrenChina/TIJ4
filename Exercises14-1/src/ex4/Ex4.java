package ex4;

abstract class Shape {

    void draw(){
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}


class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape{
    @Override
    public String toString() {
        return "Rhomboid";
    }
}

public class Ex4 {

    public static void main(String[] args) {
        Rhomboid rhomboid = new Rhomboid();
        Shape shape = (Shape) rhomboid;
        if (shape instanceof Rhomboid){
            Rhomboid rhomboid1 = (Rhomboid) shape;
        }
        if (shape instanceof Circle){
            Circle circle = (Circle) shape;
        }
    }
}