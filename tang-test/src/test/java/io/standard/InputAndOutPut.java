package io.standard;

public class InputAndOutPut {
    public static void main(String[] args) {
        // System.in 编译类型 InputStream
        // System.in 运行类型 BufferedInputStream
        // 标准输入：键盘
        System.out.println(System.in.getClass()); //class java.io.BufferedInputStream

        // 输出类型 PrintStream
        // 标准输出：显示器
        System.out.println(System.out.getClass()); //class java.io.PrintStream
    }
}
