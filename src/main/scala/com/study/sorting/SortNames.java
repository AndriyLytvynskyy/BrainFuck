package com.study.sorting;

import java.util.*;

/**
 * Given a list/array of names(String) sort them such that each name is followed by a name which starts with the last character of the previous name.
 * # input
 * [
 * Luis
 * Hector
 * Selena
 * Emmanuel
 * Amish
 * ]
 * <p/>
 * # output:
 * [
 * Emmanuel
 * Luis
 * Selena
 * Amish
 * Hector
 * ]
 */
public class SortNames {

    public static List<String> sort() {

        List<String> list = Arrays.asList(new String[]{"luis", "hector", "selena", "emmanuel", "amish"});
        List<Map<String, String>> listOfMaps = new ArrayList<>();
        String firstElement = null;
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String element = it.next();
            Map<String, String> map = new HashMap<>();
            map.put(element, null);
            for (Iterator<String> it1 = list.iterator(); it1.hasNext(); ) {
                String element1 = it1.next();
                if (element1.charAt(0) == element.charAt(element.length() - 1)) {
                    map.put(element, element1);
                    break;
                }
            }
            if (map.containsValue(null)){
                firstElement = element;
            } else {
                listOfMaps.add(map);
            }
        }

        for (Map<String, String> listOfMap : listOfMaps) {
            if (listOfMap.containsValue(firstElement)){
                String keyElement = listOfMap.keySet().iterator().next();
                firstElement = keyElement;
            }
        }
        return null;
    }

    public void traverseListOfMaps(List<Map<String, String>> maps, String firstElement){
        for (Iterator<Map<String, String>> it1 = maps.iterator(); it1.hasNext();) {
            Map<String, String> listOfMap = maps.iterator().next();
            if (listOfMap.containsValue(firstElement)) {
                String keyElement = listOfMap.keySet().iterator().next();
                firstElement = keyElement;

            }

        }

    }

    public static void main(String[] args) {
        sort();

    }


}
