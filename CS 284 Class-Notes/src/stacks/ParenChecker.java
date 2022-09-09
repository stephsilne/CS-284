package stacks;

import java.util.Stack;

public class ParenChecker {
	private static final String OPEN = "([{";
	private static final String CLOSE = ")]}";
	
	
	public static boolean isBalanced(String expression) {
		StackSLL<Character> s = new StackSLL<>();
		boolean balanced = true;
		//---
		char nextCh;
		char topCh;
		int index = 0;
		
		
		while(balanced && index < expression.length() ) {
			nextCh = expression.charAt(index);
			
			if (isOpen(nextCh)) {
				s.push(nextCh);
			} else if (isClose(nextCh)) {
				if (s.isEmpty()) {
					balanced = false;
				} else {
					topCh = s.pop();
					balanced = OPEN.indexOf(topCh) == CLOSE.indexOf(nextCh);
				}
			}
			index++;
		}
		return balanced && s.isEmpty();
	}
	
	public static boolean isBalanced_java(String expression) {
		Stack<Character> s = new Stack<>();
		boolean balanced = true;
		//---
		char nextCh;
		char topCh;
		int index = 0;
		
		
		while(balanced && index < expression.length() ) {
			nextCh = expression.charAt(index);
			
			if (isOpen(nextCh)) {
				s.push(nextCh);
			} else if (isClose(nextCh)) {
				if (s.empty()) {
					balanced = false;
				} else {
					topCh = s.pop();
					balanced = OPEN.indexOf(topCh) == CLOSE.indexOf(nextCh);
				}
			}
			index++;
		}
		return balanced && s.empty();
	}
	
	private static boolean isOpen (char ch) {
		return OPEN.indexOf(ch) > -1;
	}
	
	private static boolean isClose (char ch) {
		return CLOSE.indexOf(ch) > -1;
	}
	
	public static void main (String[] args) {
		System.out.println(isBalanced_java("[{]}()"));
		System.out.println(isBalanced_java("afadfg([fdgaadfgav]a{asddj345}312)"));
		System.out.println(isBalanced_java("["));
		System.out.println(isBalanced(""));
		System.out.println(isBalanced("]"));
		System.out.println(isBalanced("()"));
		
	}
}
