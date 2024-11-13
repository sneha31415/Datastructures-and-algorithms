package org.example.oops_learn;

public class fractionUse {
    public static void main(String[] args) throws zeroDenominatorException {
        fraction f1 = new fraction(16, 9);
        f1.print();
        fraction f2 = new fraction(10, 0);
        f2.print();
        fraction f3 = new fraction(3, 4);
        f3.print();
        f3.add(f1, f2);
        f3.print();
        fraction f4 = fraction.add(f1, f2);
    }
}
