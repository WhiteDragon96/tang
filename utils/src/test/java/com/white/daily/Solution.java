package com.white.daily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = new String[2*nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String s = String.valueOf(num);

            if (s.length() >1){
                String[] split = s.split("");
                List list = new ArrayList(Arrays.asList(strings));
                list.addAll(Arrays.asList(split));
                strings = new String[list.size()];
            }
            String[] strings1 = {String.valueOf(nums[i])};
            List list = new ArrayList(Arrays.asList(strings));
            list.addAll(Arrays.asList(strings1));
            strings = new String[list.size()];
        }
        int[] array = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}