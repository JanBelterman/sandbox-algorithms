package Recursion.RecursivePalindrome;

public class RecursivePalindromeChecker {

    public static void run() {
        System.out.println("Recursive palindrome checker\n");

        boolean isPalindrome = check("ananas");
        System.out.println(isPalindrome);
    }

    private static boolean check(String s) {
        return (s.length() <= 1) || (s.charAt(0) == s.charAt(s.length()-1 ) && check(s.substring(1, s.length() -1)));
    }

}
