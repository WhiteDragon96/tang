package com.white.daily.design.strategy;

/**
 * 创建Context类
 *
 * @author tcs
 * @date Created in 2021-08-11
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
