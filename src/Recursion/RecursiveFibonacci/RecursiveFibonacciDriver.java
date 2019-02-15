package Recursion.RecursiveFibonacci;

public class RecursiveFibonacciDriver {

    private static int previous;
    private static int current;

    public static void run() {
        System.out.println("Fibonacci recursive\n");

        previous = 0;
        current = 1;
        int fib = fibRecursive(9);
        System.out.println("Recursive: " + fib);

        previous = 0;
        current = 1;
        int fib2 = fibIterative(9);
        System.out.println("Loop: " + fib2);
    }

    private static int fibRecursive(int n) {
        if (n <= 1) return current;

        int newFib = previous + current;
        previous = current;
        current = newFib;

        return fibRecursive(n-1);
    }

    private static int fibIterative(int n) {
        for(int i = 1; i < n; i++) {
            int fib = previous + current;
            previous = current;
            current = fib;
        }

        return current;
    }

}
