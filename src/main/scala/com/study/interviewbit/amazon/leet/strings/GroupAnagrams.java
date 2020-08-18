package com.study.interviewbit.amazon.leet.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author andrii_lytvynskyi
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> result = new HashMap<>();
        for (String element : strs) {
            char[] ca = element.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!result.containsKey(key)) {
                result.put(key, new ArrayList());
            }
            result.get(key).add(element);

        }
        return new ArrayList(result.values());
//        if (strs.length == 0) return new ArrayList();
//        Map<String, List> ans = new HashMap<String, List>();
//        for (String s : strs) {
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);
//            String key = String.valueOf(ca);
//            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//            ans.get(key).add(s);
//        }
//        return new ArrayList(ans.values());


    }
}
