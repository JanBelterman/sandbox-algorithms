package StackUseCases.ParenthesesDelimiter;

import StackUseCases.Stack;

public class ParenthesesDelimiterDriver {

    public static void run() {
        System.out.println("Parentheses delimiter\n");

        System.out.println(delimitParenthesis("({[<>]})"));
        System.out.println(delimitParenthesis("({[<>]}){"));
    }

    private static boolean delimitParenthesis(String s) {
        boolean isBalanced = true;
        Stack<Character> stack = new Stack<>();

        // Loop string
        for(char c : s.toCharArray()) {
            // Char is opening -> add to stack
            if (c == '(' || c == '{' || c == '<' || c == '[') {
                stack.push(c);
            }
            // Char is closing -> check if it corresponds to last char on stack
            else {
                // If stack is empty -> invalid string -> return false
                if (stack.isEmpty()) return false;
                char fromStack = stack.peak(); stack.pop();
                switch (c) {
                    case ')': isBalanced = fromStack == '('; break;
                    case '}': isBalanced = fromStack == '{'; break;
                    case '>': isBalanced = fromStack == '<'; break;
                    case ']': isBalanced = fromStack == '['; break;
                }
            }
        }

        // TODO check if string contains unclosed parenthesis, because if alphabetical chars exist in the string false will be returned always
        // If stack is empty -> string is valid -> true
        // If stack isn't empty -> string isn't valid -> false
        return stack.isEmpty() && isBalanced;
    }

}
