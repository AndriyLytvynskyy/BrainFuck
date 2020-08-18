package com.study.interviewbit.amazon.leet.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author andrii_lytvynskyi
 */
public class IntegerToRoman {
    static Map<Integer, String> map = new HashMap();
    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
      StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i ++){
          if (values[i] <= num) {
              sb.append(symbols[i]);
              num = num - values[i];
          }
      }
       return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(11 % 10);
        int n = 53;
        while (n > 0){
            System.out.println(n % 10);
            n = n / 10;
        }
    }
}
