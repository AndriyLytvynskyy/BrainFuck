package com.study.interviewbit.strings;

/**
 * Compare two version numbers version1 and version2.
 * 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class Version {

    public int compareVersion2(String A, String B) {

        int l1 = A.length();
        int l2 = B.length();
        int l = l2;
        if (l2 > l1) {
            l = l1;
        }
        for (int i = 0; i < l; i++) {
            if (A.charAt(i) == '.' && B.charAt(i) == '.') {
                continue;
            }
            if (A.charAt(i) == '.' && B.charAt(i) != '.') {
                return -1;
            }
            if (A.charAt(i) != '.' && B.charAt(i) == '.') {
                return 1;
            }
            if (A.charAt(i) > B.charAt(i)) {
                return 1;
            }
            if (B.charAt(i) > A.charAt(i)) {
                return -1;
            }
        }
        if (l1 > l2) {
            return 1;
        }
        if (l2 > l1) {
            return -1;
        }
        return 0;
    }
    public static int compareVersion(String a, String b) {
        String[] arr1 = a.split("\\.");
        String[] arr2 = b.split("\\.");

        int i=0;
        while(i<arr1.length || i<arr2.length){
            if(i<arr1.length && i<arr2.length){
                if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
                    return -1;
                }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
                    return 1;
                }
            } else if(i<arr1.length){
                if(Integer.parseInt(arr1[i]) != 0){
                    return 1;
                }
            } else if(i<arr2.length){
                if(Integer.parseInt(arr2[i]) != 0){
                    return -1;
                }
            }

            i++;
        }

        return 0;
    }

    public static void main(String[] args) {
        compareVersion("4444371174137455", "5.168");
    }
}
