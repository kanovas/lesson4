package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public interface BinaryExpression extends Expression {
    abstract double oper(double a, double b) throws CalculationException;
}