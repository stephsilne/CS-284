package shapes;

public abstract class Shape implements Colorable {
	// Data fields
	private String color;

	// Constructor
	public Shape(String color) {
		super();
		this.color = color;
	}

	// Methods
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract double area();
	
	
}
