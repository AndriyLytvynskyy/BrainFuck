package com.study.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author andrii_lytvynskyi
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        int[] indegree = new int[numCourses];
        for(int[] e: prerequisites) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int c : graph[current]) {
                indegree[c]--;
                if(indegree[c] == 0)
                    queue.add(c);
            }
            numCourses--;
        }

        return numCourses == 0;
    }

    public static boolean canFinishMap(int numCourses, int[][] prerequisites) {
        // O(N + E) , number of courses + E is a dimension of prerequisite array
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] relation: prerequisites) {
            if (graph.containsKey(relation[1])){
                graph.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextVertices = new LinkedList<>();
                nextVertices.add(relation[0]);
                graph.put(relation[1], nextVertices);
            }
            indegree[relation[0]]++;
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int c : graph.get(current)) {
                indegree[c]--;
                if (indegree[c] == 0)
                    queue.add(c);
            }
            numCourses--;

        }

        return numCourses == 0;
    }

    public static void main(String[] args) {
        //System.out.println(canFinishMap(2, new int[][]{{1,0}, {0,1}}));
        System.out.println(canFinishMap(4, new int[][]{{3,1},{2, 0},{2,3}}));
    }
}
