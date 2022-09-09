package Tutorials;

public class ThisIsFun {

	int a;
	int b;
	 
	public ThisIsFun(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public static void main (String[] args) {
		ThisIsFun t = new ThisIsFun(4,3);
		System.out.println(t.a);
		System.out.println(t.b);
	}
}
