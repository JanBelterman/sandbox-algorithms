package Polynomials;

import java.util.ArrayList;

public class Polynomial {

    private ArrayList<Term> terms = new ArrayList<>();

    public void add(Term term) {
        terms.add(term);
    }

    public Polynomial sum(Polynomial polynomial2) {

        Polynomial poly1, poly2;

        // TODO What if both poly have the same smallest term? or if the second poly has 2 times "the" smallest term
        if(terms.get(terms.size() - 1).getExponent() <= polynomial2.terms.get(terms.size() -1).getExponent()) {
            poly1 = polynomial2;
            poly2 = this;
        } else {
            poly1 = this;
            poly2 = polynomial2;
        }

        Polynomial result = new Polynomial();
        int poly1Index = 0;
        int poly2Index = 0;

        // Loop poly that goes to smallest term value (that way all terms will be added)
        while(poly1Index < poly1.terms.size()) {
            // Get biggest term not added yet (big -> small)
            Term term1 = poly1.terms.get(poly1Index);
            Term term2 = poly2.terms.get(poly2Index);

            // Exponents are equal
            if(term1.getExponent() == term2.getExponent()) {
                result.terms.add(new Term(term1.getCoefficient() + term2.getCoefficient(), term1.getExponent()));
                poly1Index++;
                poly2Index++;
            }
            // Exponent 1 is bigger
            else if (term1.getExponent() > term2.getExponent()) {
                result.add(term1);
                poly1Index++;
            }
            // Exponent 2 is bigger
            else {
                result.add(term2);
                poly2Index++;
            }
        }

        return result;
    }

    public String toString() {
        StringBuilder string = new StringBuilder("");
        for(Term term : terms) {
            string.append(" + " + term.toString());
        }
        return string.toString();
    }

}
