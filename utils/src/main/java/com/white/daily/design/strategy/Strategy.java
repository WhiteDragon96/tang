package com.white.daily.design.strategy;

/**
 * 创建一个接口。
 *
 * @author tcs
 * @date Created in 2021-08-11
 */
public interface Strategy {
    /**
     * 策略模式
     * @param num1
     * @param num2
     * @return
     */
    public int doOperation(int num1, int num2);
}
