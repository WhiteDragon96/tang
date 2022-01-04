package com.tang.tangjuc.single;

/**
 * 静态内部类
 * @author tcs
 * @date Created in 2021-12-27
 */
public class Holder {
    // 单例模式一定是构造器私有

    private Holder(){

    }

    public static Holder getInstance(){return InnerClass.HOLDER;}

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
