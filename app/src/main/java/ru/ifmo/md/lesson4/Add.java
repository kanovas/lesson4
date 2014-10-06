package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public class Add extends Operation {

    public Add(Expression a, Expression b) {
        super(a, b);
    }

    public double oper(double a, double b) throws CalculationException {
        double s = a + b;
        if (a != s - b) {
        	throw new CalculationException("overflow: " + s + " got while calculating");
        }
        else return s;
    }

}
