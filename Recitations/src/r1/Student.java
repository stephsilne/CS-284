package r1;

public class Student extends Person {
	private double gpa;
	public Student(String firstName, String lastName, int age, double gpa) {
		super(firstName, lastName, age);
		this.gpa = gpa;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public static void main (String[] args) {
		Student s = new Student ("Josh", "H", 20, 3.9);
		s.setAge(20);
		System.out.println(s);
		System.out.println(s.getFirstName() + " has the gpa of " + s.getGpa());
	}
}
