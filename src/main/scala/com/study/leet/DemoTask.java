package com.study.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

/**
 * @author andrii_lytvynskyi
 */
public class DemoTask {
    public static String swapString(String S) {
        int i = 0, j = S.length() -1;
        char[] arr = S.toCharArray();
        while (i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i ++;
            j --;
        }
        return new String(arr);

    }
    public static String solution(String S) {
        // write your code in Java SE 8
        //A B C and D
        List<String> listTransform = new ArrayList();
        listTransform.add("AB");
        listTransform.add("BA");

        listTransform.add("CD");
        listTransform.add("DC");


        for (int i = 0;i < listTransform.size();i ++){
            String trans = listTransform.get(i);
            if (S.contains(listTransform.get(i))){
                System.out.println("Applyting" + trans);
                int index = S.indexOf(trans);
                S = S.substring(0, index) + S.substring(index + trans.length());
                System.out.println(S);
                i = -1 ;
            }


        }
        return S;

    }

    public static void main(String[] args) {
        //System.out.println(solution("CABABD"));
        System.out.println(swapString("here"));

    }

}
