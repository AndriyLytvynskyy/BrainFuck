package com.booking.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrii_Lytvynskyi on 6/30/2015.
 */
public class StringHasAllUniqueCaharcters {

    public static boolean uniqueChars(String word){
        char[] characters = word.toCharArray();
        Set<Character> setOfUniqueCharacter = new HashSet<>();
        for (Character ch:characters){
            if (!setOfUniqueCharacter.contains(ch)){
                setOfUniqueCharacter.add(ch);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueChars("wwrd"));
    }
}
