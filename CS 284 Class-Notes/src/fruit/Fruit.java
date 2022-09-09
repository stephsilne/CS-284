package fruit;

import shapes.Colorable;

public abstract class Fruit implements Colorable {
	// data fields
	private String color;
	private Boolean seeds;
	private double weight;
	
	// Constructor
	
	public Fruit(String color, Boolean seeds, double weight) {
		super();
		this.color = color;
		this.seeds = seeds;
		this.weight = weight;
	}
	
	// Methods
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Boolean getSeeds() {
		return seeds;
	}
	public void setSeeds(Boolean seeds) {
		this.seeds = seeds;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
	
}
