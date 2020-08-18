package com.study.leet;

/**
 * @author andrii_lytvynskyi
 */
public class StringCompresion {

    public static int compress(char[] chars) {
        char[] out = new char[]{};
        if (chars.length == 1) {
            return 1;
        }
        int i = 0;
        out[i] = chars[i];
        for (int j = i; j < chars.length;j++){
            if (chars[j] != chars[i]) {
                out[i + 1] = Character.forDigit(j - i, 10);
                i = j;
            }


        }
        return chars.length;

    }

    public static void main(String[] args) {
        System.out.println(compress(new String("aabb").toCharArray()));
    }
}
