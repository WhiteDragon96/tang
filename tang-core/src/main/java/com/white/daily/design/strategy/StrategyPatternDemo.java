package com.white.daily.design.strategy;

/**
 * @author tcs
 * @date Created in 2021-08-11
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        int num1 = 2, num2 = 3;
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(num1, num2));
        System.out.println(new Context(new OperationMultiply()).executeStrategy(num1, num2));


    }
}
