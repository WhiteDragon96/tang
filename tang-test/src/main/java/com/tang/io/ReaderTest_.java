package com.tang.io;

/**
 * @author tcs
 * @date Created in 2022-03-18
 */
public class ReaderTest_ {
    public static void main(String[] args) {
        FileReader_ fileReader_ = new FileReader_();
        BufferReader_ bufferReader_ = new BufferReader_(fileReader_);
        bufferReader_.readFile(5);
        bufferReader_.readString(5);
    }
}

