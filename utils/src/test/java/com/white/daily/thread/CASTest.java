package com.white.daily.thread;

/**
 * 使用 CAS 实现一个线程安全的计数器
 *
 * @author tcs
 * @date Created in 2021-07-20
 */
public class CASTest {
    public static void main(String[] args) {
        CASCounter casCounter = new CASCounter();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(casCounter.incrementAndGet());
                }
            }).start();
        }
    }
}

class CASCounter {
    //使用volatile修饰value值，使线程可见
    volatile private long value;

    public long getValue() {
        return value;
    }

    // 定义compare and swap方法
    private boolean compareAndSwap(long expectedValue, long newValue) {
        //如果当前 value 的值与期望的 expectedValue 值一样,就把当前的 Value 字段替换为 newValue 值

        synchronized (this) {
            if (value == expectedValue) {
                value = newValue;
                return true;
            }
            return false;
        }
    }

    //定义自增方法
    public long incrementAndGet() {
        long oldValue;
        long newValue;
        do {
            oldValue = value;
            newValue = value + 1;
        } while (!compareAndSwap(oldValue, newValue));
        return newValue;
    }
}
