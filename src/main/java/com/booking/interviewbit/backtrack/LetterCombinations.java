package com.booking.interviewbit.backtrack;

import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {
    public ArrayList<String> letterCombinations(String a) {
        Map<Character, String> combinations = new HashMap<Character, String>();
        combinations.put('2', "abc");
        combinations.put('3', "def");
        combinations.put('4', "ghi");
        combinations.put('5', "jkl");
        combinations.put('6', "mno");
        combinations.put('7', "pqrs");
        combinations.put('8', "tuv");
        combinations.put('9', "wxyz");
        combinations.put('0', "0");
        combinations.put('1', "1");
        StringBuilder b = new StringBuilder();
        List<String> result = new LinkedList<String>();
        if ((a.length() < 1)) {
            return new ArrayList<String>(result);
        }

        searchCombs(a, 0, b, combinations, result);
        return new ArrayList<String>(result);
    }

    public void searchCombs(String digits, int step, StringBuilder b, Map<Character, String> combinations, List<String> result) {
        if (step == digits.length()) {
            result.add(b.toString());
            return;
        }
        Character c = digits.charAt(step);
        String s = combinations.get(c);
        for (int i = 0; i < s.length(); i++) {
            b.append(s.charAt(i));
            searchCombs(digits, step + 1, b, combinations, result);
            b.deleteCharAt(b.length() - 1);
        }

    }

    public static void main(String[] args) {
        List<String> ls = new LetterCombinations().letterCombinations("23");
        for (String l : ls) {
            System.out.println(l);
        }
    }
}
