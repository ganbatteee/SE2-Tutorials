package to_dos.prototype;

import java.util.HashMap;

/* Create the ShapeDraw class which uses ShapeCache class
to get clones of shapes stored in a Hashtable. */
public class ShapeDraw {
	// TODO: Implement the main() method for testing purpose

	public static final HashMap<String, Shape> shapeHashMap = new HashMap<>();
	public static void main(String[] args) {
		// run loadCache() method
		ShapeCache.loadCache();

		/*
		 * create 3 cloned shapes with 3 different types Hint: use getShape() &
		 * getType() methods
		 */
		Shape rec = ShapeCache.getShape("3");
		System.out.println("Rectangle: " + rec.getType());

		Shape square = ShapeCache.getShape("2");
		System.out.println("Square: " + square.getType());

		Shape circle = ShapeCache.getShape("1");
		System.out.println("Circle: " + circle.getType());
	}
}