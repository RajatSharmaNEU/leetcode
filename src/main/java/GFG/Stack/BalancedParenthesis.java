package GFG.Stack;

import java.util.Stack;

public class BalancedParenthesis {
    private boolean isMatching(char curr, char stackLast) {
        if ((curr == ')' && stackLast == '(')
                || (curr == '}' && stackLast == '{')
                || (curr == ']' && stackLast == '[')
        ) {
            return true;
        }

        return false;
    }

    private boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(input.charAt(i));
            } else if (isMatching(curr, stack.peek()) == false) {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "{}([()])";
//        String input = "((())";
//        String input = "([)]";
        BalancedParenthesis balancedParenthesis = new BalancedParenthesis();
        System.out.println(balancedParenthesis.isBalanced(input));
    }
}
