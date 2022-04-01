package com.tang.io;

/**
 * @author tcs
 * @date Created in 2022-03-18
 */
public class BufferReader_ extends Reader_ {

    private Reader_ reader_;

    public BufferReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    public void readFile(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    public void readString(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readString();
        }
    }
}
