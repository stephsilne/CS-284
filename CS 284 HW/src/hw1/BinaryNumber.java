package hw1;

/**
 * 
 * @author Stephaan Silne
 * @class CS 284: Data Structures
 * @assignment Homework 1
 * @date 02/14/2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 */

public class BinaryNumber {
	private int data[];
	private int length;
	
	//CONSTRUCTORS!
	/**
	 * 
	 * @param length How many zeros should be in the array that will 
	 * symbolize the binary number.
	 */
	public BinaryNumber(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("Length must be positive and greater than 0 to compute");
		}
		this.length = length;
		this.data = new int [length];
		
	}
	/**
	 * 
	 * @param str Given a string, it will transform the binary number
	 * into an array.
	 */
	public BinaryNumber(String str) {
		this.length = str.length();
		this.data = new int[length];
		
		for (int i = 0; i < str.length(); i++) {
			this.data[i] = java.lang.Character.getNumericValue(str.charAt(i));			
		}
		
	}
	//METHODS!
	/**
	 * @return The method returns the length of the object.
	 */
	public int getLength() {
		return this.length;	
	}
	/**
	 * 
	 * @param index Location in the array that represents a binary number.
	 * @return returns the location of said index but throws exception
	 * if the index given is out of bounds.
	 */
	public int getDigit(int index) {
		if (index < 0 || index > this.getLength()-1 ) {
			throw new IndexOutOfBoundsException("The index you have given is out of bounds!");
		}
		return this.data[index];	
		
	}
	/**
	 * 
	 * @return returns the data field array that represents the binary number.
	 */
	public int[] getInnerArray() {
		return this.data;
		
	}
	
	/**
	 * 
	 * @param bn1 first binary number in an array form.
	 * @param bn2 second binary number in an array form.
	 * @return returns the bitwise OR of both binary numbers
	 */
	public static int[] bwor (BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.getLength() != bn2.getLength()) {
			throw new IllegalArgumentException("Must be of same length, cannot compute :(");
		}
		int [] binOR = new int[bn1.getLength()];
		
		for (int i = 0; i < bn1.getLength(); i++) {
			if (bn1.getDigit(i) == 1 || bn2.getDigit(i) == 1) {
				binOR[i] = 1;
			}
			else {
				binOR[i] = 0;
			}
		}
		
		return binOR;
	}
	
	/**
	 * 
	 * @param bn1 first binary number in an array form.
	 * @param bn2 second binary number in an array form.
	 * @return returns the bitwise AND of both binary numbers.
	 */
	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.getLength() != bn2.getLength()) {
			throw new IllegalArgumentException("Must be of same length, cannot compute :(");
		}
		int [] binAND = new int[bn2.getLength()];
		
		for (int i = 0; i < bn2.getLength(); i++) {
			if (bn1.getDigit(i) == 1 && bn2.getDigit(i) == 1) {
				binAND[i] = 1;
			}
			else {
				binAND[i] = 0;
			}
		}
		
		return binAND;
		
	}
	/**
	 * 
	 * @param direction : either a -1 (shift left) or 1 (shift right)
	 * @param amount : a given amount to shift by ~ how much.
	 */
	public void bitShift(int direction, int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Must be given a non-negative integer to shift, sorry :(");
		}
		// direction to the right
		if (direction == 1) {
			int[] shftbin = new int [this.getLength()-amount];
			for (int i = 0; i < shftbin.length; i++) {
				shftbin[i] = this.data[i];
			}
			this.data = shftbin;
			this.length = shftbin.length;
		}
		// direction to the left
		else if (direction == -1) {
			int[] shftbin = new int [this.getLength() + amount];
			for (int i = 0; i < this.getLength(); i ++) {
				shftbin[i] = this.data[i];
			}
			for (int j = this.getLength(); j < this.getLength() + amount; j++ ) {
				shftbin[j] = 0;
			}
			// update the data array
			this.data = shftbin;
			this.length = shftbin.length;
		}
		// otherwise
		else {
			throw new IllegalArgumentException ("Must be given -1 or 1 to compute, sorry :( ");
		}
		
	}
	
	/**
	 * 
	 * @param amount adds 0's to the front of a binary number that calls
	 * the method.
	 */
	public void prepend(int amount) {
		int[] newbin = new int [this.getLength() + amount];
		for (int i = amount; i < amount + this.getLength(); i ++) {
			newbin[i] = this.data[i - amount];
		}
		// update the data array
		this.data = newbin;
		this.length = newbin.length;
	}
	
	/**
	 * 
	 * @param aBinaryNumber a binary number that will be added to 
	 * the array object that calls the method.
	 */
	public void add(BinaryNumber aBinaryNumber) {
		if (aBinaryNumber.getLength() > this.getLength()) {
			int num = aBinaryNumber.getLength() - this.getLength();
			this.prepend(num);
		}
		if (aBinaryNumber.getLength() < this.getLength()) {
			int num = this.getLength() - aBinaryNumber.getLength();
			aBinaryNumber.prepend(num);
		}
		
		int[] Addbin = new int[this.getLength()];
		
		int crrybit = 0;
		for (int i = this.getLength() - 1; i >= 0; i--) {
			// start with the adding of the last place.
			int fulladder = crrybit + this.getDigit(i) + aBinaryNumber.getDigit(i);
			// all digits are zeros!
			if (fulladder == 0) {
				Addbin[i] = 0;
				crrybit = 0;
			}
			// all digits are ones!
			else if (fulladder == 3) {
				Addbin[i] = 1;
				crrybit = 1;
			}
			// either the carry is 0 and the other terms are one or carry is 1 and the other terms alternate
			else if (fulladder == 2) {
				Addbin[i] = 0;
				crrybit = 1;
			}
			//either carry is 1 and both digits are 0 or carry is 0 and other terms alternate
			else if (fulladder == 1) {
				Addbin[i] = 1;
				crrybit = 0;
			}
		}
		
		this.data = Addbin;
		this.length = Addbin.length;
		
		// if there is still a carry bit of 1 that goes over after adding,
		if (crrybit == 1) {
			this.prepend(1);
			this.data[0] = 1;
			this.length += 1;
		}
		
	}
	/**
	 * OVERRIDE.
	 */
	public String toString() {
		String strng = new String();
		for (int i = 0; i < this.getLength(); i++) {
			strng += this.getDigit(i);
		}
		return strng;
	}
	
	/**
	 * 
	 * @return returns the decimal representation of a binary number.
	 */
	public int toDecimal() {
		int dec = 0;
		int pwr = 0;
		for (int i = this.getLength()-1; i >= 0; i--) {
			dec += this.data[i] * Math.pow(2, pwr);
			pwr++;
		}
		return dec;
		}
	}

