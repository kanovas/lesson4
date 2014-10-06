package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public abstract class SingleOperation implements SingleExpression {
    protected Expression expr;

    SingleOperation(Expression x) {
        expr = x;
    }

    @Override
    public double evaluate() throws CalculationException {
        return oper(expr.evaluate());
    }

}