package Polynomials;

public class Term {

    private int coefficient;
    private int exponent;

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public String toString() {
        return coefficient + "x^" + exponent;
    }

}
