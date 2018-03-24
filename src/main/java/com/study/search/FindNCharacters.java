package com.study.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Lytvynskyi on 6/18/2015.
 */
public class FindNCharacters {
    public static List<Character> getFirstNChars(String s){
        List<Character> list = new ArrayList<Character>();
        for (int i=0;i<5;i++){
            list.add(s.charAt(i));
        }

        for (Character character : list) {
            System.out.println(character);
        }
        return list;
    }

    public static void main(String[] args) {
        getFirstNChars("absdefghijklmnop");
    }
}
