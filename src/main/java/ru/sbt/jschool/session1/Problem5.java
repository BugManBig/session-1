package ru.sbt.jschool.session1;

import java.util.HashSet;
import java.util.Set;

public class Problem5 {
    public static void main(String[] args) {
        System.out.println(binaryToDec("1011"));
        System.out.println(sumOfBinary("111", "1"));
        long[] inters = intersection(new long[]{2, 4, 8, 2}, new long[]{4, 6, 9, 9});
        for (long elem : inters) {
            System.out.println(elem);
        }
    }

    public static long binaryToDec(String binary) {
        long result = 0;
        for (int i = 0; i < binary.length(); i++) {
            result += Math.pow(2, i) * (binary.charAt(binary.length() - 1 - i) - 48);
        }
        return result;
    }

    public static long sumOfBinary(String b1, String b2) {
        if (b1.length() < b2.length()) {
            while (b1.length() < b2.length()) {
                b1 = "0" + b1;
            }
        }
        if (b1.length() > b2.length()) {
            while (b1.length() > b2.length()) {
                b2 = "0" + b2;
            }
        }
        String result = "";
        int extra = 0;
        int digit1;
        int digit2;
        int sum;
        for (int i = b1.length() - 1; i >= 0; i--) {
            digit1 = b1.charAt(i) - 48;
            digit2 = b2.charAt(i) - 48;
            sum = digit1 + digit2 + extra;
            if (sum > 1) {
                extra = 1;
                sum -= 2;
            } else {
                extra = 0;
            }
            result = sum + result;
        }
        result = extra + result;
        return Long.parseLong(result);
    }

    public static long[] intersection(long[] arr1, long[] arr2) {
        Set<Long> same = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    same.add(arr1[i]);
                }
            }
        }
        long[] result = new long[same.size()];
        for (int i = 0; i < same.size(); i++) {
            result[i] = (Long) same.toArray()[i];
        }
        return result;
    }
}
