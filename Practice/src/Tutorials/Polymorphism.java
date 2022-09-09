package Tutorials;

class Bird{
	public void sing() {
		System.out.println("tweet, tweet, tweet");
	}
}
public class Polymorphism {

	public static void main (String [] args) {
		Bird b = new Bird();
		b.sing();	
	}
}
