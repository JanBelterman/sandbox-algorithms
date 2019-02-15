package StackUseCases.PostfixCalculator;

import StackUseCases.Stack;

public class PostfixCalculatorDriver {

    public static void run() {
        System.out.println("Postfix calculator\n");

        try {
            System.out.println(calculatePostFix("2 2 + 2 - 2 +"));
            System.out.println(calculatePostFix("10 5 * 2 +"));
        } catch (NotEnoughOperandsException e) {
            e.printStackTrace();
        }
    }

    private static int calculatePostFix(String string) throws NotEnoughOperandsException {
        Stack<Integer> stack = new Stack<>();

        // Loop string
        String[] array = string.split(" ");
        for(String s : array) {
            // Check if char is an operator
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (stack.size() >= 2) {
                    int one = stack.pop();
                    int two = stack.pop();
                    switch (s) {
                        case "+":
                            stack.push(two + one);
                            break;
                        case "-":
                            stack.push(two - one);
                            break;
                        case "*":
                            stack.push(two * one);
                            break;
                        case "/":
                            stack.push(two / one);
                            break;
                    }
                } else {
                    throw new NotEnoughOperandsException("Not enough operands in stack");
                }
            }
            // Check if char is a operand
            else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

}
