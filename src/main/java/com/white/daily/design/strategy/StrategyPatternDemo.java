package com.white.daily.design.strategy;

/**
 * @author tcs
 * @date Created in 2021-08-11
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(1,2));


    }
}
