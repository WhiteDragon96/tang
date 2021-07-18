package com.white.daily.annotation;

/**
 * @author tcs
 * @date Created in 2021-03-30
 */
public class AnnotationTest {

    @NewAnnotation(value = "mainMethod",fontColor = NewAnnotation.FontColor.BLUE)
    public static void main(String[] args) {

    }

    @NewAnnotation(value="sayMethod")
    public static void saying() {

    }
}
