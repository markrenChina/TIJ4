package ex3;

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

public class Ex3 {

    public static void main(String[] args) {
        Rhomboid rhomboid = new Rhomboid();
        Shape shape = (Shape) rhomboid;
        Rhomboid rhomboid1 = (Rhomboid) shape;
        Circle circle = (Circle) shape;
    }
}