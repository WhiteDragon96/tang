package com.white.daily.design.observer;

import java.util.Observer;

/**
 * @author tcs
 * @date Created in 2021-04-28
 */
public interface Subject {

    /**
     *注册一个观察者
     * @param observer
     */
    void register(Observer observer);

    /**
     * 移除一个观察者
     * @param observer
     */
    void remove(Observer observer);

    /**
     * 发出通知
     */
    void notifyObserver();
}
