package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public class MyCalculateEngine implements CalculationEngine {

    @Override
    public double calculate(String expression) throws CalculationException {
        return ExpressionParser.parse(expression).evaluate();
    }
}
