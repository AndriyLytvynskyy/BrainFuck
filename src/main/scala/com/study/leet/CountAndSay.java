package com.study.leet;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 */
public class CountAndSay {

//    public static String countAndSay(int n) {
//
//        String result = "1";
//        int i = 1;
//
//        while (i < n) {
//            StringBuilder sb = new StringBuilder();
//            int count = 1;
//            for (int j = 1; j < result.length(); j++) {
//                if (result.charAt(j) == result.charAt(j - 1)) {
//                    count++;
//                } else {
//                    sb.append(count);
//                    sb.append(result.charAt(j - 1));
//                    count = 1;
//                }
//            }
//
//            sb.append(count);
//            sb.append(result.charAt(result.length() - 1));
//            result = sb.toString();
//            i++;
//        }
//
//        return result;
//    }

    public static String countAndSay(int n){
        String result = "1";
        int i = 1;
        while (i <n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }

            }
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
    }
}
