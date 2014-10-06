package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public interface SingleExpression extends Expression {
    abstract double oper(double a) throws CalculationException;
}
