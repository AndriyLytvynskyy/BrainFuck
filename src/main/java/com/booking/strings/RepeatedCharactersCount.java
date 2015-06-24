package com.booking.strings;

/**
 * Implement a method to perform basic string compression using the counts of
   repeated characters. the string aabcccccaaa would become
 a2blc5a3
 */
public class RepeatedCharactersCount {

    public static String compression(String input){
        char ch = input.charAt(0);
        StringBuilder str = new StringBuilder();
        int count = 1;
        str.append(ch);
        for (int i = 1;i<input.length();i++){
           char nextChar = input.charAt(i);
            if (ch == nextChar){
                count++;
            } else {
                str.append(count);
                ch = nextChar;
                str.append(ch);
                count = 1;
            }
         if ((i == input.length()-1)){
             str.append(count);
         }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(compression("aabcccccaaa"));
    }

}
