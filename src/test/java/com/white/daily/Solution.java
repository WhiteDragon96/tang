package com.white.daily;


class Solution {
    public static void main(String[] args) {
        Integer.bitCount(93^73);
        int i = hammingDistance(93, 73);
        System.out.println("result is " + i);
    }

    public static int hammingDistance(int x, int y) {
        String sb = Integer.toBinaryString(x);
        String yb = Integer.toBinaryString(y);
        int count = 0;
        char[] chars = sb.toCharArray();
        char[] chary = yb.toCharArray();
        char[] chartt;
        if (sb.length() > yb.length()) {
            int length = sb.length() - yb.length();
            chartt = new char[yb.length() + length];
            for (int i = 0; i < chartt.length; i++) {
                if (i < length) {
                    chartt[i] = 48;
                } else {
                    chartt[i] = chary[i - length];
                }
            }

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != chartt[i]) {
                    count++;
                }
            }
            return count;
        } else if (yb.length() >= sb.length()) {
            int length2 = yb.length() - sb.length();
            chartt = new char[sb.length() + length2];
            for (int i = 0; i < chartt.length; i++) {
                if (i < length2) {
                    chartt[i] = 48;
                } else {
                    chartt[i] = chars[i - length2];
                }
            }
            for (int i = 0; i < chary.length; i++) {
                if (chary[i] != chartt[i]) {
                    count++;
                }
            }
            return count;
        }

        return 0;
    }
}