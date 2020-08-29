package shape;
import static com.tij4.util.Print.*;
public class Circle extends Shape {
	@Override
	public void draw() { print("Circle.draw()"); }
	@Override
	public void erase() { print("Circle.erase()"); }
}
