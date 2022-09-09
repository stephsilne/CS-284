package Tutorials;

public class Cat extends Dog{

	private int food;
	
	public Cat(String name, int age, int food) {
		super(name, age);
		this.food = food;
	}
	
	public Cat(String name, int age) {
		super(name, age);
		this.food = 50;
	}
}
