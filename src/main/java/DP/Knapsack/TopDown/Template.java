package DP.Knapsack.TopDown;

public class Template {

    public int knapsack(int W, int val[], int wt[]) {
        //Top-Down

        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int i = 0; i <= n; i++){
            for(int j =0; j <= W; j++){
                //1. Intialization -> Base Case
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    // Main Logic
                    if(wt[i-1] <= j){
                        dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],
                                dp[i-1][j]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        return dp[n][W];
    }
}
