package ru.ifmo.md.lesson4;

import java.util.ArrayList;

/**
 * Created by kano_vas on 07.10.14.
 */
public class ExpressionParser {

    static Expression parseAddSub() throws CalculationException {
        Expression left = parseMulDiv();
        Expression right;
        while (l < r) {
            if (!expr[l].equals("+") && !expr[l].equals("-")) {
                break;
            }

            char sign = expr[l].charAt(0);
            switch (sign) {
                case '+':
                    l++;
                    right = parseMulDiv();

                    left = new Add(left, right);
                    break;
                case '-':
                    l++;
                    right = parseMulDiv();
                    left = new Subtract(left, right);
                    break;
            }
        }

        return left;
    }

    static Expression parseMulDiv() throws CalculationException{
        Expression left = parseBrackets();
        Expression right;
        while (l < r) {
            if (!expr[l].equals("*") && !expr[l].equals("/") && !expr[l].equals("%")) {
                break;
            }

            char sign = expr[l].charAt(0);
            switch (sign) {
                case '*':
                    l++;
                    right = parseBrackets();
                    left = new Multiply(left, right);
                    break;
                case '/':
                    l++;
                    right = parseBrackets();
                    left = new Divide(left, right);
                    break;
            }
        }

        return left;
    }

    static Expression parseBrackets() throws CalculationException {
        if (expr[l].equals("(")) {
            l++;
            Expression ret = parseAddSub();
            if (!expr[l].equals(")")) {
                throw new CalculationException("expected ) at " + l);
            }
            l++;
            return ret;
        } else {
            return parseUnary();
        }
    }

    static Expression parseUnary() throws CalculationException{
        char tmp = expr[l].charAt(0);
        Expression inside;
        switch (tmp) {
            case '+':
                l++;
            case '-':
                if (isNumber(expr[l + 1])) {
                    return parseNum();
                }
                l++;
                inside = parseUnary();
                return new Neg(inside);
        }
        return parseNum();
    }

    static Expression parseNum() throws CalculationException {
        if (l < r && expr[l].equals("(")) {
            return parseBrackets();
        }
        Expression ret;
        if(expr[l].equals("-")) {
            l++;
            sign = "-";
        }
        if(isNumber(expr[l])) {
            ret = new Const(Double.parseDouble(sign + expr[l]));
            l++;
        }
        else {
            throw new CalculationException("format problems");
        }
        return ret;
    }

    static boolean isBracket(char c) {
        return c == '(' || c == ')';
    }

    static boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '~';
    }

    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean isNumber(String s) {return isDigit(s.charAt(0));}

    static boolean isVariable(char c) {
        return c == 'x' || c == 'y' || c == 'z';
    }

    static String[] expr;
    static String sign = "";
    static int l, r;

    public static Expression parse(String str) throws CalculationException {
        ArrayList<String> zz = new ArrayList<String>();
        int i = 0;
        String num;
        boolean f = false;
        while(i < str.length()) {
            StringBuilder sb = new StringBuilder();
            while (i < str.length() && (isDigit(str.charAt(i)) ||(!f && str.charAt(i) == '.'))) { //digit or one point
                sb.append(str.charAt(i));
                if(str.charAt(i) == '.') {
                    if (f) throw new CalculationException("points problem you have");
                    f = true;
                }
                i++;
            }
            num = sb.toString();
            if (!num.equals("")) {
                zz.add(num);
                f = false;
            }
            else if(isBracket(str.charAt(i)) || isOperation(str.charAt(i)) || isVariable(str.charAt(i))) {
                zz.add(Character.toString(str.charAt(i)));
                i++;
            }
            else if(str.charAt(i) == 'm') {
                zz.add("%");
                i += 3;
            }
            else i++;
        }
        expr = new String[zz.size()];
        for(i = 0; i < expr.length; i++) {
            expr[i] = zz.get(i);
        }
        l = 0;
        r = expr.length;
        return parseAddSub();
    }
}
