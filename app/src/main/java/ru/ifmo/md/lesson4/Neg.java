package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public class Neg extends SingleOperation {
    public Neg(Expression a) {
        super(a);
    }

    public double oper(double a) throws CalculationException {
        return -a;
    }
}