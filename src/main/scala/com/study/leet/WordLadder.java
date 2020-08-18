package com.study.leet;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * https://www.youtube.com/watch?v=O3hUyXyHeBw - very good explanation
 *
 * @author andrii_lytvynskyi
 */
 class Obj {
    String word;
    int level;
    Obj(String word, int level){
        this.word = word;
        this.level = level;
    }

}
public class WordLadder {

    //Time Complexity = O (n * n * K (largest String in the given word list))
    public static int ladderLengthT(String beginWord, String endWord, List<String> wordList) {
        int level = 0;
        if (!wordList.contains(endWord) || beginWord.isEmpty() || endWord.isEmpty()){
            return level;
        }
        Queue<Obj> wordsQueue = new LinkedList();
        wordsQueue.add(new Obj(beginWord, 1));

        while (!wordsQueue.isEmpty()){
            Obj wordCurr = wordsQueue.poll();
            ListIterator<String> iter = wordList.listIterator();

            while (iter.hasNext()){
                String wordFromList = iter.next();
                if (isSimilar(wordCurr.word, wordFromList)){
                    iter.remove();
                    wordsQueue.add(new Obj(wordFromList, wordCurr.level + 1));

                    if (wordFromList.equals(endWord)){
                        return wordCurr.level + 1;
                    }
                }

            }
        }
        return 0;
    }

    private static boolean isSimilar(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

//        Iterator<String> iter = wordList.iterator();
//
//        while (iter.hasNext()){
//            int count = 0;
//            String wordFromList = iter.next();
//            if (wordFromList.equals(word)){
//                iter.remove();
//                return true;
//            }
//
//            for (int i = 0; i < word.length(); i++){
//                if (word.charAt(i) != wordFromList.charAt(i)){
//                    count ++;
//                    if (count > 1){
//                        break;
//                    }
//                }
//            }
//            if (count == 1){
//                wordsQueue.add(wordFromList);
//                iter.remove();
//                return true;
//            }
//
//        }
//        return false;

//    }

    public static void main(String[] args) {
        System.out.println(ladderLengthT("hit", "cog", new ArrayList(Arrays.asList("hot","dot","dog","lot","log","cog"))));
        System.out.println(ladderLengthT("a", "c", new ArrayList(Arrays.asList("a","b","c"))));
    }


    public int ladderLengthMod(String beginWord, String endWord, List<String> wordList) {

         Set<String> set = new HashSet<>(wordList);
        if (!set.contains(beginWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i< size; i ++){
                String currentWord = queue.poll();
                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j ++){
                    char originalChar = wordChars[j];
                    for (char c = 'a'; c < 'z'; c++){
                        if (wordChars[j] == c) continue;
                        wordChars[j]=c;
                        String newWord = String.valueOf(wordChars);
                        if (newWord.equals(endWord)) return level + 1;
                        if (set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    wordChars[j] = originalChar;
                }
            }
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }


}
