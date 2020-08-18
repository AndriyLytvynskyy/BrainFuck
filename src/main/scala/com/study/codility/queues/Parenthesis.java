package com.study.codility.queues;
import java.util.*;
/**
 * @author andrii_lytvynskyi
 */
public class Parenthesis {
    public static int solution(String S) {
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        // write your code in Java SE 8
        Stack<Character> stack = new Stack<Character>();
        char[] chars = S.toCharArray();
        for (Character ch: chars){
            if (map.containsKey(ch)){
                stack.push(ch);
            } else{
                if (stack.isEmpty()){
                    return 0;
                }
                Character openExpected = stack.pop();
                if (ch != map.get(openExpected)){
                    return 0;
                }
            }


        }
        return stack.size() > 0?0:1;
    }

    public static void main(String[] args) {
        System.out.println(solution(")("));
    }
}
