package DatasStructures;
import java.util.*;

public class BalancingBrackets {

	static Scanner sc = new Scanner(System.in);
	
	static boolean checkingBalanced(String brackets) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < brackets.length(); i++) {
			char ch = brackets.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				continue;
			}
			if (stack.isEmpty())
				return false;
			
			char value;
			
			switch (ch) {
			case '}':
				value = stack.pop();
				if (value == '(' || value == '[')
					return false;
				break;
			case ']':
				value = stack.pop();
				if (value == '{' || value == '(')
					return false;
				break;
			case ')':
				value = stack.pop();
				if (value == '{' || value == '[')
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		
		String brackets = "([[{}]])";
		Boolean result;
	}

}
