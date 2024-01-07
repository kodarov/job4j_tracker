package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return (int) Math.round((double) y / x);
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);

        Calculator calc = new Calculator();
        result = calc.multiply(4);
        System.out.println(result);

        result = Calculator.minus(2);
        System.out.println(result);

        result = calc.divide(31);
        System.out.println(result);

        result = calc.sumAllOperation(3);
        System.out.println(result);
    }
}