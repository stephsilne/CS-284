package Tutorials;

public class Dog {
	
	protected String name;
	protected int age;
	protected static int count = 0;
	// constructor
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
		Dog.count += 1;
	}
	
	public static void display() {
		System.out.println("I am a dog!");
	}

	
}

