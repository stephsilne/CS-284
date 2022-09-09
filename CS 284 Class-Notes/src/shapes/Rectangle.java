package shapes;

public class Rectangle extends Shape {
	// Data fields
	private double width;
	private double height;
	
	private static int noOfRectangles=0;
	
	// Constructors
	
	Rectangle(double width, double height, String color) {
		super(color);
		this.width = width;
		this.height = height;
		noOfRectangles++;
	}
	
	Rectangle(double width, double height) {
		this(width,height,"Blue");
	}
	
	
	
	Rectangle() {
		this(0,0);
//		this.width=0;
//		this.height=0;
//		noOfRectangles++;
	}
	
	// Methods
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
		
	public void setHeight(double height) {
		this.height = height;
	}
		
	
	@Override
	public String toString() {
		return "I am a Rectangle. My width is "+width+" and my height is "+height;
	}

	public Pair<Double,Double> getWidthAndHeight() {
		return new Pair<Double,Double>(width,height);
	}

	public Pair<Double,String> getWidthAndColor() {
		return new Pair<Double,String>(width,this.getColor());
	}
	
	public double area() {
		return width*height;
	}
	
	public static int getNoOfRectangles() {
		return noOfRectangles;
	}
	
	// Main method
//	public static void main(String[] args) {
//		Rectangle r1 = new Rectangle();
//		Rectangle r2 = new Rectangle(1.7,7.2);
//		
//		System.out.println(r1.getWidth()); // prints 0.0
//		r1.setWidth(3.4);
//		System.out.println(r1.getWidth()); // prints 3.4
//		
//		System.out.println(r2.getWidth()); // prints 1.7
//		
//		System.out.println(r2);
//		
//		System.out.println(Rectangle.noOfRectangles); // prints 2
//	}
//	
	
}
