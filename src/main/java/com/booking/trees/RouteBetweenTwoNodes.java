package com.booking.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * 4.2
 * Given a directed graph, design an algorithm to find out whether there is a route
    between two nodes.
 */

public class RouteBetweenTwoNodes {
    enum State {
        Unvisited, Visited, Visiting;
    }
    class Node{
        State state;
        List<Node> adjacent;

        public List<Node> getAdjacent() {
            return adjacent;
        }

        public void setAdjacent(List<Node> adjacent) {
            this.adjacent = adjacent;
        }
    }
    class Graph{
        List<Node> nodes;

        public List<Node> getNodes() {
            return nodes;
        }

        public void setNodes(List<Node> nodes) {
            this.nodes = nodes;
        }
    }

    public static boolean search(Graph g, Node start, Node end) {
        // operates as Queue
        LinkedList<Node> q = new LinkedList<Node>();
        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst(); // i.e., dequeueQ
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;

    }
}
