package ru.ifmo.md.lesson4;

/**
 * Created by kano_vas on 07.10.14.
 */
public class Const implements Expression {

    double c;

    public Const(double v) {
        c = v;
    }

    public double evaluate() {
        return c;
    }
}
