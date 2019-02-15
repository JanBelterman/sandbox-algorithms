package Polynomials;

public class PolynomialsDriver {

    public static void run() {
        System.out.println("Polynomials\n");

        // Create first polynomial
        Polynomial polynomial = new Polynomial();
        polynomial.add(new Term(1, 2));
        polynomial.add(new Term(3, 1));
        polynomial.add(new Term(1, 0));

        // Create second polynomial
        Polynomial polynomial1 = new Polynomial();
        polynomial1.add(new Term(-1, 3));
        polynomial1.add(new Term(2, 2));
        polynomial1.add(new Term(-5, 0));

        // Determine the sum
        Polynomial sumPolynomial = polynomial.sum(polynomial1);

        System.out.println(sumPolynomial);
    }

}
