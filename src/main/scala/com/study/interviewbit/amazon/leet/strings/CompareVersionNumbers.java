package com.study.interviewbit.amazon.leet.strings;

/**
 * @author andrii_lytvynskyi
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] chunks1 = version1.split("\\.");
        String[] chunks2 = version2.split("\\.");
        int n1 = chunks1.length;
        int n2 = chunks2.length;
        int i1,i2;
        //we need to traverse only over the largest string
        for (int i = 0; i< Math.max(n1, n2); i++){
            i1 = i < n1 ? Integer.parseInt(chunks1[i]) : 0; //pad with zeros
            i2 = i < n2 ? Integer.parseInt(chunks2[i]) : 0; //pad with zeros
            if (i1 != i2) {
                return i1 > i2? 1 : -1;
            }
        }
        return 0;
    }

}
