package shapes;

public class Circle extends Shape {
	// data fields
	private double radius;

	// Constructor
	
	public Circle(double radius, String color) {
		super(color);
		this.radius = radius;
	}
	
	public Circle(double radius) {
		this(radius,"Blue");
	}

	// Methods
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	public double area() {
		return  Math.PI * radius* radius;
	}
	
	public String toString() {
		return "I am a Circle. My radius is "+radius + " and my color is "+ this.getColor();
	}
	
}
