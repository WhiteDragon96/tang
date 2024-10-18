package com.white.daily.design.strategy;

/**
 * @author tcs
 * @date Created in 2021-08-11
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1+num2;
    }
}
