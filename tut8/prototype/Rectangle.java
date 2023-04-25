package to_dos.prototype;

//Create the Rectangle concrete class which extends the Shape abstract class
public class Rectangle extends Shape {
	// TODO: Declare the constructor
	public Rectangle() {
		// Set type to be similar with class name
		this.type = "RECTANGLE";
	}

	// TODO: Declare the draw() method
	@Override
	public void draw() {
		/*
		 * Only print out the draw() method to test. No need to implement the real
		 * drawing
		 */
		System.out.println("This is Rectangle");
	}
}