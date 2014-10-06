package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public class Divide extends Operation {

    public Divide(Expression a, Expression b) {
        super(a, b);
    }

    public double oper(double a, double b) throws CalculationException {
        if(b == 0) {
            throw new CalculationException("division by zero");
        }
        else return a / b;
    }
}