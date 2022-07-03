package ex6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ex6.Shape.tag;

abstract class Shape {

    static Set<Class<? extends Shape>> tags = new HashSet<>();

public static void tag(Class<? extends Shape> clz){
        //父类的this依然执行子类的Class
        tags.add(clz);
    }

    void draw(){
        System.out.println(this + ".draw()");
    }

        abstract public String toString();;
}


class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle is tag " + tags.contains(this.getClass());
    }

}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square is tag " + tags.contains(this.getClass());}

}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangleis tag " + tags.contains(this.getClass());
    }

}

public class Shapes {

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(),new Square(),new Triangle()
        );
        tag(Circle.class);
        for (Shape shape: shapeList){
            shape.draw();
        }
    }
}