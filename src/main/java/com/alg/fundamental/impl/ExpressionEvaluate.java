package com.alg.fundamental.impl;

import com.alg.fundamental.base.IExpressionEvaluate;

public class ExpressionEvaluate implements IExpressionEvaluate {

    private MyStack<Double> vals;
    private MyStack<String> ops;

    public ExpressionEvaluate() {
        vals = new MyStack<>();
        ops = new MyStack<>();
    }

    @Override
    public Double eval(String expression) {
        int i = 0;
        while (i < expression.length()) {
            String s = "" + expression.charAt(i);
            if ("(".equalsIgnoreCase(s)) {

            } else if ("+".equalsIgnoreCase(s)) {
                ops.push("+");
            } else if ("-".equalsIgnoreCase(s)) {
                ops.push("-");
            } else if ("/".equalsIgnoreCase(s)) {
                ops.push("/");
            } else if ("*".equalsIgnoreCase(s)) {
                ops.push("*");
            } else if ("s".equalsIgnoreCase(s)
                    && 'q' == expression.charAt(i + 1)
                    && 'r' == expression.charAt(i + 2)
                    && 't' == expression.charAt(i + 3)) {
                ops.push("sqrt");
                i += 3;
                if ('(' == expression.charAt(i + 1)) {
                    i += 2;
                    int temp = i;
                    StringBuilder num = new StringBuilder();
                    while (expression.charAt(temp) != ')') {
                        num.append(expression.charAt(temp++));
                    }
                    i = temp - 1;
                    vals.push(Double.parseDouble(num.toString()));
                }
            } else if (")".equalsIgnoreCase(s)) {
                String op = ops.pop();
                Double val = 0.0 + vals.pop();
                switch (op) {
                    case "+":
                        val = vals.pop() + val;
                        break;
                    case "-":
                        val = vals.pop() - val;
                        break;
                    case "/":
                        val = vals.pop() / val;
                        break;
                    case "*":
                        val = vals.pop() * val;
                        break;
                    case "sqrt":
                        val = Math.sqrt(val);
                        break;
                }
                vals.push(val);
            } else {
                vals.push(Double.parseDouble(s));
            }
            i++;
        }
        return vals.pop();
    }
}
