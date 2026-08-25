package DP.Knapsack.Memoization;

import java.util.Arrays;

public class Template {

    public int knapsack(int W, int val[], int wt[]) {
        //Memoization
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        return knapsackHelper(dp,val,wt,W,n);

    }

    private int knapsackHelper(int[][] dp,int val[], int wt[], int W, int n){
        if(n == 0 || W == 0){
            return 0;
        }

        if(dp[n][W] != -1) return dp[n][W];


        if(wt[n-1] <= W){
            dp[n][W] = Math.max(val[n-1]+knapsackHelper(dp,val,wt,W-wt[n-1],n-1),knapsackHelper(dp,val,wt,W,n-1));
        }
        else{
            dp[n][W] = knapsackHelper(dp,val,wt,W,n-1);
        }

        return dp[n][W];
    }
}
