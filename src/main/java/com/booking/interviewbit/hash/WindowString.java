package com.booking.interviewbit.hash;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
 * Note that when the count of a character C in T is N, then
 * the count of C in minimum window in S should be at least N.
 */
class Range {
    private int start;
    private int end;
    public Range (int s, int e){
        start = s;
        end = e;
    }

    public int length() {
        return end -start +1;
    }
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
public class WindowString {

     static Range shortestSuperSequence(char[] bigWord, char[] smallWord){
        int bestStart = -1;
        int bestEnd = -1;
        for (int i =0; i< bigWord.length;i++) {
            int end = findClosure(bigWord, smallWord, i);
            if (end == -1) {
                break;
            }
            if (bestStart == -1 || end -i < bestEnd - bestStart){
                bestStart = i;
                bestEnd = end;
            }
        }
        return new Range (bestStart, bestEnd);
    }

    static int findClosure(char[] bigWord, char[] smallWord, int index){
        int max = -1;
        for (int i =0; i< smallWord.length;i++) {
            int next = findNextInstance(bigWord, smallWord[i], index);
            if (next == -1){
                return -1;
            }
            max = Math.max(next, max);
        }
        return max;
    }
    static int findNextInstance(char[]array, int element, int index){
        for (int i = index; i< array.length;i++) {
            if (array[i] == element){
                return i;
            }
        }
        return -1;
    }
    public static String minWindow(String s, String t) {
        String subString = "";
        if (s.length()>=t.length()){
            if (s.contentEquals(t)) {
                subString = t;
            } else {
                Range r = shortestSuperSequence(s.toCharArray(), t.toCharArray());
                if ((r.length() >= 1) && (r.getStart() >= 0) && (r.getEnd()>=0)) {
                    subString = s.substring(r.getStart(), r.getEnd() + 1);
                }
            }
        }
        return subString;
    }


    public static void main(String[] args) {
        String S = "bbaa";
        String T = "aba";
//        String S = "ADOBECODEBANC";
//        String T = "ABC";
//        String S = "w";
//        String T = "o";

        System.out.println(minWindow(S, T));
    }
}
