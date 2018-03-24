package com.study.interviewbit.trees;

import java.util.ArrayList;

/**
 * Find shortest unique prefix to represent each word in the list.
 *
 *
 * Input: [zebra, dog, duck, dove]
   Output: {z, dog, du, dov}
   where we can see that
   zebra = z
   dog = dog
   duck = du
   dove = dov
 *
 *
 * Efficient data structure here:
 *
 * https://www.geeksforgeeks.org/trie-insert-and-search/
 * https://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/
 */
// Java program to print all prefixes that
// uniquely represent words.
class TrieFirstTime {

    static final int MAX = 256;

    // Maximum length of an input word
    static final int MAX_WORD_LEN = 500;

    // Trie Node.
    class TrieNode {
        TrieNode[] child = new TrieNode[MAX];
        int freq;  // To store frequency

        TrieNode() {
            freq = 1;
            for (int i = 0; i < MAX; i++)
                child[i] = null;
        }
    }

    TrieNode root;

    // Method to insert a new string into Trie
    void insert(String str) {
        // Length of the URL
        int len = str.length();
        TrieNode pCrawl = root;

        // Traversing over the length of given str.
        for (int level = 0; level < len; level++) {
            // Get index of child node from current character
            // in str.
            int index = str.charAt(level);

            // Create a new child if not exist already
            if (pCrawl.child[index] == null)
                pCrawl.child[index] = new TrieNode();
            else
                (pCrawl.child[index].freq)++;

            // Move to the child
            pCrawl = pCrawl.child[index];
        }
    }

    void findPrefixesUtil(TrieNode root, char[] prefix,
                          int ind, ArrayList<String> list) {
        // Corner case
        if (root == null)
            return;

        // Base case
        if (root.freq == 1)
        {
            prefix[ind] = '\0';
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while(prefix[i] != '\0') {
                sb.append(prefix[i++]);
                //System.out.print(prefix[i++]);
            }
            list.add(sb.toString());
            //System.out.print("  ");
            return;
        }

        for (int i=0; i<MAX; i++)
        {
            if (root.child[i] != null)
            {
                prefix[ind] = (char) i;
                findPrefixesUtil(root.child[i], prefix, ind+1, list);
            }
        }
    }

    void findPrefixes(String arr[], int n, ArrayList<String> list){

        // Construct a Trie of all words
        root = new TrieNode();
        root.freq = 0;
        for (int i = 0; i<n; i++)
            insert(arr[i]);

        // Create an array to store all prefixes
        char[] prefix = new char[MAX_WORD_LEN];

        // Print all prefixes using Trie Traversal
        findPrefixesUtil(root, prefix, 0, list);
    }
}

public class ShortestUniquePrefix {
//    public ArrayList<String> prefix(ArrayList<String> A) {
//        ArrayList<String> results = new ArrayList<String>();
//        new TrieFirstTime().findPrefixes(A.toArray(new String[A.size()]), A.size(), results);
//        return results;
//    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> results = new ArrayList<String>();
        new TrieFirstTime().findPrefixes(A.toArray(new String[A.size()]), A.size(), results);
        return results;
    }
    public static void main(String[] args) {
        //String arr[] = {"zebra", "dog", "duck", "dot"};
        String arr[] = {"lrbbmqb", "cd", "r", "owkk"};

        int n = arr.length;
        TrieFirstTime trie = new TrieFirstTime();
        ArrayList<String> results = new ArrayList<String>();
        trie.findPrefixes(arr, n, results);

        ArrayList<String> results1 = new ArrayList<String>();
        for (String input : arr) {
            for (String result : results) {
                if (input.startsWith(result)) {
                    results1.add(result);
                }
            }
        }
//
        for (String result : results1) {
           System.out.println(result);
      }


    }


}
