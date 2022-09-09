package r1;

public class Undergrad extends Student {
	private String year;
	
	public Undergrad (String firstName, String lastName, int age, double gpa, String year) {
		super (firstName, lastName, age, gpa);
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String toString() {
		return super.toString() + " and are a " + year;

	}
	
	public static void main (String[] args) {
		Undergrad u = new Undergrad("Steph", "Silne",19, 3.9, "Junior");
		System.out.println(u);
	}
}
