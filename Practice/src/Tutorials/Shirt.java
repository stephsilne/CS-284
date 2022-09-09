package Tutorials;

public class Shirt {

	// data fields
	public String color;
	public char size;
	
	
	public static void putOn() {
		System.out.println("Shirt is on");
	}
	
	public static void takeOff() {
		System.out.println("Shirt is off");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	
}
