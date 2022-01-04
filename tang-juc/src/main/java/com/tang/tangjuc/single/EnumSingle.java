package com.tang.tangjuc.single;

/**
 * enum 本身也是一个Class类
 *
 * @author tcs
 * @date Created in 2021-12-27
 */
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) {
        EnumSingle instance = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;
        System.out.println(instance);
        System.out.println(instance2);
    }
}