package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public interface Expression {
    abstract double evaluate() throws CalculationException;
}
