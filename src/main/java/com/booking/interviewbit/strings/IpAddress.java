package com.booking.interviewbit.strings;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p/>
 * A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
 */
public class IpAddress {
    public ArrayList<String> restoreIpAddresses(String A) {
        int ip;
        ArrayList<String> res = new ArrayList<>();
        dfs(res, 0, A, 3, "");

        Collections.sort(res);

        return res;
    }

    public void dfs(ArrayList<String> res, int startIndex, String A, int num, String ip) {

        if (num == 0) {
            int len = A.length();

            if (len - startIndex > 3 || len - startIndex < 1)
                return;

            String str = A.substring(startIndex, len);
            int val = Integer.parseInt(str);

            if (val < 0 || val > 255)
                return;

            if (str.charAt(0) == '0' && str.length() > 1)
                return;

            res.add(ip + str);

            return;

        }

        for (int i = startIndex + 1; i <= Math.min(A.length(), startIndex + 3); i++) {
            String str = A.substring(startIndex, i);
            int val = Integer.parseInt(str);
            if (val > 255)
                continue;

            if (str.charAt(0) == '0' && str.length() > 1)
                return;

            dfs(res, i, A, num - 1, ip + str + ".");
        }

    }

    public static void main(String[] args) {

    }
}
