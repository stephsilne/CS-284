package fruit;

public class Apple extends Fruit {
	// Data fields
	private String origin;
	
	// Constructor
	public Apple(String origin, String color, Boolean seeds, double weight) {
		super(color,seeds,weight);
		this.origin = origin;
	}
	
	
}
