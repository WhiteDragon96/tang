package com.white.daily.design.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * 天气预报站，向观察者（第三方网站Observer）发送通知
 *
 * @author tcs
 * @date Created in 2021-04-28
 */
public class WeatherData implements Subject {
    //天气信息
    private Double temperature;
    private Double humidity;
    //观察者集合
    private List<Observer> observers;

    public WeatherData() {
        // TODO Auto-generated constructor stub
        observers = new ArrayList<>();
        temperature = 0.0;
        humidity = 0.0;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> {
//            observer.update();
        });
    }
}
