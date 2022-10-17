package com.tang.redis;


import java.math.BigInteger;

public class AdHocAlgorithm {
    public static void main(String[] args) {
        System.out.println(new AdHocAlgorithm().bottleCapCalculation(50));
    }

    public int bottleCapCalculation(int money){

        int result = money;
        int capsule = money;

        while (capsule>5){
            result = result+ capsule/5;
            capsule = capsule - capsule/5*5 + capsule/5
            ;
            int i = 1;

        }
        return result;
    }
}
