package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example {

	
	public static void readAndPrintTextFile(String name) {
		
		File f = new File(name);
		Scanner c;
		try {
			c = new Scanner(f);
			while (c.hasNextLine()) {
				System.out.println(c.nextLine());
			}
			
			c.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Oops!");
			e.printStackTrace();
		}
		
		
	}
	
	public static int get(int[] a, int index) {
		if (index<0) {
			throw new ArrayIndexOutOfBoundsException("method get");
		}
		return a[index];
	}
	
	
	public static void main(String[] args) {
		
		readAndPrintTextFile("myfile.txt");
		
		int[] a = new int[3];
		
		try {
		a[0]= 1;
		a[1]= 2;
		a[2]= 3;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Careful!");
		}
		
		System.out.println(get(a,-3));
		
	}
}
