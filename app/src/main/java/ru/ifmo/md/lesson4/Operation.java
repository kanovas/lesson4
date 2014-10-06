package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public abstract class Operation implements BinaryExpression {
    protected Expression expr1;
    protected Expression expr2;

    Operation(Expression x, Expression y) {
        expr1 = x;
        expr2 = y;
    }

    @Override
    public double evaluate() throws CalculationException {
        return oper(expr1.evaluate(), expr2.evaluate());
    }
}
