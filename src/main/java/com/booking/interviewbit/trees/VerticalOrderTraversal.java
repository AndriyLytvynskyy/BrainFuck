package com.booking.interviewbit.trees;


import java.util.*;

/**
 * Given a binary tree, print a vertical order traversal of it.
 * <p>
 * 6
 * /   \
 * 3     7
 * / \     \
 * 2   5     9
 * <p>
 * <p>
 * <p>
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 * <p>
 * The idea is to traverse the tree once and get the minimum and maximum horizontal distance with respect to root.
 * For the tree shown above, minimum distance is -2 (for node with value 4) and maximum distance is 3 (For node with value 9).
 * Once we have maximum and minimum distances from root, we iterate for each vertical line at distance minimum to maximum from root,
 * and for each vertical line traverse the tree and print the nodes which lie on that vertical line.
 */

/**
 * Interesting findings: TreeMap sorts by key automatically
 */
class Values {
    int max, min;
}

class Node {
    int val;
    int depth;

    public Node(int val, int depth) {
        this.val = val;
        this.depth = depth;
    }
}


public class VerticalOrderTraversal {
    TreeNode root;
    Values val = new Values();

    // A utility function to find min and max distances with respect
    // to root.
    void findMinMax(TreeNode node, Values min, Values max, int hd) {

        // Base case
        if (node == null)
            return;

        // Update min and max
        if (hd < min.min)
            min.min = hd;
        else if (hd > max.max)
            max.max = hd;

        // Recur for left and right subtrees
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }

    // A utility function to print all nodes on a given line_no.
    // hd is horizontal distance of current node with respect to root.
    private int getHeight(TreeNode root) {
        if (root == null) return 0; // Base case
        return Math.max(getHeight(root.left),
                getHeight(root.right)) + 1;
    }

    private void verticalOrderTraversalHelp(TreeNode node, int line_no, int hd, Map<Integer, ArrayList<Node>> map) {
        // Base case
        if (node == null)
            return;

        // If this node is on the given line number
        if (hd == line_no) {
            if (!map.containsKey(line_no)) {
                map.put(line_no, new ArrayList<>());
            }
            map.get(line_no).add(new Node(node.val, getHeight(node)));
            //result.get(line_no).add(node.val);
        }

        // Recur for left and right subtrees
        verticalOrderTraversalHelp(node.left, line_no, hd - 1, map);
        verticalOrderTraversalHelp(node.right, line_no, hd + 1, map);
    }


    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        // Find min and max distances with resepect to root
        findMinMax(A, val, val, 0);

        // Iterate through all possible vertical lines starting
        // from the leftmost line and print nodes line by line
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<Node>> map = new TreeMap<>();
        for (int line_no = val.min; line_no <= val.max; line_no++) {
            verticalOrderTraversalHelp(A, line_no, 0, map);
        }

        for (Integer integer : map.keySet()) {
            List<Node> list = map.get(integer);
            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.depth, o2.depth);
                }
            });
            ArrayList<Integer> ls = new ArrayList<>();
            for (Node node : list) {
                ls.add(node.val);
            }
            result.add(ls);


        }
        return result;

    }

    public static void main(String[] args) {

//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//
//        result.add(1, new ArrayList<>());
//        System.out.println(result);


        List<Integer> ls = new ArrayList<>();
        ls.add(5);
        ls.add(7);
        ls.add(3);
        Collections.sort(ls, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 < o2) ? 1 : (o1 > o2) ? -1 : 0;
            }
        });
        for (Integer l : ls) {
            System.out.println(l);
        }

    }

}
