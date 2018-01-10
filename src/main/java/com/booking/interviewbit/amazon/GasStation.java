package com.booking.interviewbit.amazon;

/**
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 * You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
 * Completing the circuit means starting at i and ending up at i again.
 *
 *
 Input :
 Gas :   [1, 2]
 Cost :  [2, 1]

 Output : 1

 If you start from index 0, you can fill in gas[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need cost[0] = 2 gas to travel to station 1.
 If you start from index 1, you can fill in gas[1] = 2 amount of gas. Now your tank has 2 units of gas. You need cost[1] = 1 gas to get to station 0. So,
 you travel to station 0 and still have 1 unit of gas left over.
 You fill in gas[0] = 1 unit of additional gas, making your current gas = 2. It costs you cost[0] = 2 to get to station 1, which you do and complete the circuit.
 *
 */
public class GasStation {
//    1) if the sum of gas >= the sum of cost, then the circle can be completed.
//    2) if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.

    public static int canCompleteCircuitAnother(int[] gas, int[] cost) {
        //choose start from the end of the gas list
        // choose end from the end of the gas list
        int start = gas.length - 1;
        int end = 0;
        int remainingSum = gas[start] - cost[start];
        while (start > end){
            if (remainingSum >=0) {
                remainingSum += gas[end] - cost[end];
                ++end;
            } else {
                --start;
                remainingSum += gas[start] - cost[start];
            }
        }
        if (remainingSum >=0) {
            return start;
        } else {
            return -1;
        }

    }
    public static int canCompleteCircuitCorrectSolution(int[] gas, int[] cost) {
        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int remaining = gas[i] - cost[i];

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
                //otherwise, reset start index to be current
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            return start;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {


    }
}
