package hw5;
/**
 * 
 * @author Stephaan Silne
 * @Class CS 284: Data Structures
 * @Assignment Homework 5: Anagrams
 * @Date May 8, 2021
 * @Pledge "I pledge my honor that I have abided by the Stevens Honor System"
 * 
 */
import java.util.Map;

import junit.framework.TestCase;

public class AnagramsTest extends TestCase{

	
	public void testbuildLetterTable() {
		Anagrams a = new Anagrams();
		Map<Character,Integer> lt = a.letterTable;
		System.out.println(lt);
		assertTrue(lt.get('a') == 2);
		assertTrue(lt.get('b') == 3);
		assertTrue(lt.get('m') == 41);
		assertTrue(lt.get('r') == 61);
		assertFalse(lt.get('e') == 2);
		assertTrue(lt.get('w') == 83);
		assertTrue(lt.get('z') == 101);
		assertFalse(lt.get('p') == 10);
		assertFalse(lt.get('x') == 83);
		
	}

	public void testmyHashCode() {
		Anagrams a = new Anagrams();
		System.out.println(a.myHashCode("rail"));
		assertFalse(a.myHashCode("finger") == a.myHashCode("planet"));
		assertTrue(a.myHashCode("alerts") == 236204078);
		System.out.println(a.myHashCode(null));
		assertTrue(a.myHashCode("fried") == a.myHashCode("fired"));
		assertTrue(a.myHashCode("sadder") == a.myHashCode("dreads"));
		assertTrue(a.myHashCode("superintended") == a.myHashCode("unpredestined"));
		assertFalse(a.myHashCode("listen") == a.myHashCode("silent"));
	}
	
	public void testaddWord() {
		Anagrams a = new Anagrams();
		a.addWord("race");
		a.addWord("care");
		a.addWord("acre");
		a.addWord("acer");
		a.addWord("triangle");
		a.addWord("integral");
		a.addWord("altering");
		a.addWord("alerting");
		a.addWord("relating");
		a.addWord("tanglier");
		a.addWord("listen");
		a.addWord("silent");
		a.addWord("enlist");
		a.addWord("tinsel");
		a.addWord("inlets");
		a.addWord("silent");
		a.addWord("leading");
		a.addWord("aligned");
		a.addWord("dealing");
		a.addWord("dealign");
		a.addWord("creator");
		a.addWord("reactor");
		System.out.println(a.anagramTable);
		
	}
	public void getMaxEntries() {
		Anagrams a = new Anagrams();
		a.addWord("race");
		a.addWord("care");
		a.addWord("repents");
		a.addWord("acre");
		a.addWord("stephaan");
		a.addWord("acer");
		a.addWord("triangle");
		a.addWord("integral");
		a.addWord("altering");
		a.addWord("taste");
		a.addWord("picture");
		a.addWord("dealer");
		a.addWord("penster");
		a.addWord("alerting");
		a.addWord("relating");
		a.addWord("tanglier");
		a.addWord("listen");
		a.addWord("able");
		a.addWord("bale");
		a.addWord("enlist");
		a.addWord("tinsel");
		a.addWord("inlets");
		a.addWord("present");
		a.addWord("silent");
		a.addWord("leading");
		a.addWord("aligned");
		a.addWord("state");
		a.addWord("serpent");
		a.addWord("pheasant");
		a.addWord("dealing");
		a.addWord("cuprite");
		a.addWord("dealign");
		a.addWord("testa");
		a.addWord("leader");
		a.addWord("creator");
		a.addWord("reactor");
		a.getMaxEntries();
	}
}

