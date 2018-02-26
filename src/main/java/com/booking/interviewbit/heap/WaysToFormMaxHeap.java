package com.booking.interviewbit.heap;

import java.util.Arrays;
import java.util.List;

/**
 * Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes. If you want to know more about Heaps, please visit this link

 So now the problem statement for this question is:
 How many distinct Max Heap can be made from n distinct integers

 In short, you have to ensure the following properties for the max heap :

 Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. )

 Every node is greater than all its children

 Let us take an example of 4 distinct integers. Without loss of generality let us take 1 2 3 4 as our 4 distinct integers

 Following are the possible max heaps from these 4 numbers :
 *
 *
 *
 * How to build a heap is show here: https://www.youtube.com/watch?v=WsNQuCa_-PU
 *
 * https://www.geeksforgeeks.org/number-ways-form-heap-n-distinct-integers/
 *
 */

class SolutionWorkingWaysToFormHeap {
    public class Solution {

        long[] dp;  	/* dp[i] = number of max heaps for i distinct integers */
        long[][] nck;	/* nck[i][j] = i choose j if i>=j else 0 */
        int[] log2;		/* log2[i] = int(log base 2 of i) */

        final long MOD = 1000000007;

        public long choose(int n,int k)
        {
            if(k>n)
                return 0;
            if(n<=1)
                return 1;
            if(k==0)
                return 1;

            if(nck[n][k]!=-1)
                return nck[n][k];
            long answer = choose(n-1,k-1) + choose(n-1,k);
            answer%=MOD;
            nck[n][k] = answer;
            return answer;
        }

        public int getL(int n)
        {
            if(n==1)
                return 0;

            int h = log2[n];
            int p = n - ((1<<(h)) - 1);
            int m = (1<<h);
            if(p>=(m/2))
                return (1<<(h)) - 1;
            else
                return (1<<(h)) - 1 - ((m/2) - p);
        }

        public int solve(int n)
        {
            dp = new long[n+1];
            for(int i=0;i<=n;i++)
                dp[i]=-1;

            nck = new long[n+1][n+1];
            for(int i=0;i<=n;i++)
                for(int j=0;j<=n;j++)
                    nck[i][j] = -1;

            log2 = new int[n+1];
            int currLogAnswer = -1;
            int currPower2 = 1;
            for(int i=1;i<=n;i++)
            {
                if(currPower2==i)
                {
                    currLogAnswer++;
                    currPower2*=2;
                }
                log2[i] = currLogAnswer;
            }

            return (int)getNumberOfMaxHeaps(n);
        }

        public long getNumberOfMaxHeaps(int n)
        {
            if(n<=1)
                return 1;

            if(dp[n]!=-1)
                return dp[n];

            int L = getL(n);
            long ans = (choose(n-1,L)*getNumberOfMaxHeaps(L))%MOD*(getNumberOfMaxHeaps(n-1-L));
            ans%=MOD;
            dp[n] = ans;
            return ans;
        }
    }

}
public class WaysToFormMaxHeap {
    private static final int MAXN = 1000;

    // dp[i] = number of max heaps for i distinct integers
    int dp[] = new int[MAXN];

    // nck[i][j] = number of ways to choose j elements
    //      form i elements, no order
    int nck[][] = new int[MAXN][MAXN];

    // log2[i] = floor of logarithm of base 2 of i
    int log2[] = new int[MAXN];

    // to calculate nCk
    int choose(int n, int k)
    {
        if (k > n)
            return 0;
        if (n <= 1)
            return 1;
        if (k == 0)
            return 1;

        if (nck[n][k] != -1)
            return nck[n][k];

        int answer = choose(n - 1, k - 1) + choose(n - 1, k);
        nck[n][k] = answer;
        return answer;
    }


    int getLeft(int n)
    {
        if (n == 1)
            return 0;

        int h = log2[n];

        // max number of elements that can be present in the
        // hth level of any heap
        int numh = (1 << h); //(2 ^ h)

        // number of elements that are actually present in
        // last level(hth level)
        // (2^h - 1)
        int last = n - ((1 << h) - 1);

        // if more than half-filled
        if (last >= (numh / 2))
            return (1 << h) - 1; // (2^h) - 1
        else
            return (1 << h) - 1 - ((numh / 2) - last);
    }

    // find maximum number of heaps for n
    int numberOfHeaps(int n) {

        if (n <= 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int left = getLeft(n);
        int ans = (choose(n - 1, left) * numberOfHeaps(left)) *
                (numberOfHeaps(n - 1 - left));
        dp[n] = ans;
        return ans;
    }

    public long solve(int n) {
        for (int i = 0; i <= n; i++)
            dp[i] = -1;

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                nck[i][j] = -1;

        int currLog2 = -1;
        int currPower2 = 1;

        // for each power of two find logarithm
        for (int i = 1; i <= n; i++) {
            if (currPower2 == i) {
                currLog2++;
                currPower2 *= 2;
            }
            log2[i] = currLog2;
        }

        return numberOfHeaps(n);
    }



    public static void main(String[] args) {
       List<Integer> list =  Arrays.asList(1,2,3,4,5);
       WaysToFormMaxHeap ways = new WaysToFormMaxHeap();
        System.out.println(ways.solve(20) % 1000000007);
    }


}
