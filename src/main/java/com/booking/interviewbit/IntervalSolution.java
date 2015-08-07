package com.booking.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 */


 class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }


public class IntervalSolution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        Collections.sort(intervals, (o1, o2) -> Long.valueOf(o1.start).compareTo(Long.valueOf(o2.start)));

        Interval result = newInterval;
        for (Iterator<Interval> it = intervals.iterator();it.hasNext();){
            Interval interval = it.next();
            if (!notOverlap(interval, newInterval)) {
                result.start = Math.min(interval.start, result.start);
                result.end = Math.max(interval.end, result.end);
                it.remove();
            }
        }
        intervals.add(result);
        Collections.sort(intervals, (o1, o2) ->  Long.valueOf(o1.start).compareTo(Long.valueOf(o2.start)));
        return intervals;
    }

    public boolean notOverlap(Interval interval1, Interval interval2){
        return (Math.max(interval1.start, interval2.start) > Math.min(interval1.end, interval2.end));
    }


    public static void main(String[] args) {

    }
}
