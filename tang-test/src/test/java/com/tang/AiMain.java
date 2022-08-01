package com.tang;

import java.util.Scanner;

/**
 * AI核心代码
 * @author tcs
 * @date: 2022-07-26  14:34
 */
public class AiMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            str = str.replace("吗", "").replace("？", "!").replace("?", "!");
            System.out.println(str);
        }
    }
}
