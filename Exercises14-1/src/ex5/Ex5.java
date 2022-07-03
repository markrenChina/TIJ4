package ex5;

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

public class Ex5 {

    static void rotate(Shape shape) {
        if (shape instanceof Circle){
            return ;
        } else {
            System.out.println(shape + " rotate!");
        }
    }

    public static void main(String[] args) {
        rotate(new Circle());
        rotate(new Triangle());
    }
}