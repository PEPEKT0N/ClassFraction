package org.example.fraction;

public class SimpleFraction {
    int numerator;
    int denominator;


    // конструкторы
    public SimpleFraction() {}
    public SimpleFraction (int numerator, int denominator) {
        this.numerator = numerator;
        setDenominator(denominator);
    }

    // getters & setters
    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            this.denominator = 1;
            return;
        }
        if (denominator < 0) {
            this.numerator *= -1;
            this.denominator = -denominator;
            return;
        }
        this.denominator = denominator;
    }

    // методы
    public void changeSign() {
        numerator *= -1;
    }

    private static SimpleFraction[] commonDenominator (SimpleFraction left, SimpleFraction right) {
        int commonDenominator = left.denominator * right.denominator;
        int newLeftNumerator = left.getNumerator() * right.getDenominator();
        int newRightNumerator = right.getNumerator() * left.getDenominator();

        return new SimpleFraction[] {
                new SimpleFraction(newLeftNumerator, commonDenominator),
                new SimpleFraction(newRightNumerator, commonDenominator)
        };
    }

    public SimpleFraction plus(SimpleFraction other) {
        SimpleFraction[] tmp = commonDenominator(this, other);
        return new SimpleFraction(tmp[0].getNumerator() + tmp[1].getNumerator(), tmp[0].getDenominator());
    }

    public static SimpleFraction plus(SimpleFraction left, SimpleFraction right) {
        SimpleFraction[] tmp = commonDenominator(left, right);
        return new SimpleFraction(tmp[0].getNumerator() + tmp[1].getNumerator(), tmp[0].getDenominator());
    }

    public SimpleFraction minus(SimpleFraction other) {
        SimpleFraction[] tmp = commonDenominator(this, other);
        return new SimpleFraction(tmp[0].getNumerator() - tmp[1].getNumerator(), tmp[0].getDenominator());
    }

    public SimpleFraction multiply(SimpleFraction other) {
        return new SimpleFraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public SimpleFraction divide(SimpleFraction other) {
        if (other.numerator == 0) {
            return new SimpleFraction(0, 1);
        }
        SimpleFraction reverseFraction = new SimpleFraction(other.denominator, other.numerator);
        return this.multiply(reverseFraction);
    }

    public int getFullPart() {
        int fullPart = this.numerator / this.denominator;
        this.numerator %= this.denominator;
        this.numerator = Math.abs(this.numerator);
        return fullPart;
    }

    private int fractionGcd() {
        int a = this.numerator;
        int b = this.denominator;
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public void fractionReduction() {
        int gcd = fractionGcd();
        this.setNumerator(this.numerator / gcd);
        this.setDenominator(this.denominator / gcd);
    }

    @Override
    public String toString() {
        return String.format("(%d/%d)", numerator, denominator);
    }
}
