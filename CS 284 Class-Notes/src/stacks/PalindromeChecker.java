package stacks;

public class PalindromeChecker {

	// data fields!
	private String inputString;
	private StackSLL <Character> s;
	
	PalindromeChecker(String str){
		inputString = str.replaceAll("\\s", "");
		fillStack(str);
	}
	
	private void fillStack(String str) {
		for (int i = 0; i <str.length(); i++) {
			if (str.charAt(i) != ' ') {
				s.push(str.charAt(i));
			}
		}
	}
	private String buildReverse() {
		StringBuilder s = new StringBuilder();
		while (!s.isEmpty()) {
			result.append(s.pop());
		}
		return result.toString();
	}
	
	private Boolean isPalindrome() {
		return inputString.equalsIgnoreCase(buildReverse());
	}
	private static void main (String [] args) {
		PalindromeChecker p1 = new PalindromeChecker ("kayak");
		
		System.out.println(p1.isPalindrome());
	}
}
