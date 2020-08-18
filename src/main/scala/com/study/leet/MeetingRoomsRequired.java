package com.study.leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author andrii_lytvynskyi
 */
public class MeetingRoomsRequired {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0){
            return 0;
        }
        //priority queue by end time
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });
        //sort by start time
        Arrays.sort(intervals, (ar1, ar2) ->{
            if (ar1[0] == ar2[0]) return 0;
            return (ar1[0] < ar2[0]) ? -1:1;

        });
        // Add the first meeting
        allocator.add(intervals[0][1]);
        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();

    }

    public static void main(String[] args) {
        minMeetingRooms(new int[][]{{9, 10}, {4,9}, {4, 17}});
    }
}
