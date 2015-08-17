package com.booking.interviewbit;

/**
 * Created by Andrii_Lytvynskyi on 8/11/2015.
 */
public class ExcelProblem2 {
    public static String convertToTitle(int a) {
        StringBuilder sb = new StringBuilder();

        while(a > 0){
            a--;
            char ch = (char) (a % 26 + 'A');
            a /= 26;
            sb.append(ch);
        }

        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        convertToTitle(10);
        StringBuilder sb = new StringBuilder();
        char ch = 67;
        sb.append(ch);
        System.out.println(sb.toString());
    }
}
