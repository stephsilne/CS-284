package rolodex;

import junit.framework.TestCase;

public class RolodexTest extends TestCase {

	public void testcontains() {
		Rolodex r = new Rolodex();
		System.out.println(r.contains("Albert"));
	}
	public void testaddCard() {
		Rolodex r = new Rolodex();
		r.addCard("Ty", "1244");
		r.addCard("Gemma", "23");
		r.addCard("Anthony", "3");
		r.addCard("Zeke", "4");
		r.addCard("Bobby", "5");
		r.addCard("Zeke", "4");
		System.out.println(r);
		
	}
	public void testsize() {
		Rolodex r = new Rolodex();
		r.addCard("Ty", "1244");
		r.addCard("Gemma", "23");
		r.addCard("Anthony", "3");
		assertEquals(r.size(), 3);
	}
	public void testremoveCard() {
		Rolodex r = new Rolodex();
		r.addCard("Chloe", "123");
		r.addCard("Chad", "23");
		r.addCard("Cris", "3");
		r.removeCard("Chloe", "123");
		r.removeCard("Chad", "2");
	}
	public void testremoveAllCards() {
		Rolodex r = new Rolodex();
		r.addCard("Chloe", "123");
		r.addCard("Chad", "23");
		r.addCard("Cris", "3");
		r.addCard("Cris", "4");
		r.addCard("Cris", "5");
		r.removeAllCards("Chad");
		r.removeAllCards("Chloe");
		r.removeAllCards("Daisy");
		System.out.println(r);
	}
	public void testnextSeparator() {
		Rolodex r = new Rolodex();
		r.initializeCursor();
		r.nextSeparator();
		r.nextSeparator();
		r.nextSeparator();
		r.nextSeparator();
		r.nextSeparator();
		r.nextSeparator();
	}
}
