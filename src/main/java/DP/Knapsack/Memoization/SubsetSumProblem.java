package DP.Knapsack.Memoization;

public class SubsetSumProblem {
    static Boolean[][] dp;
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;

        dp = new Boolean[n+1][sum+1];

        return helper(arr,sum,n);

    }

    private static boolean helper(int arr[], int sum,int n){
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }

        if(dp[n][sum] != null){
            return dp[n][sum];
        }

        if(arr[n-1] <= sum){
            dp[n][sum] = helper(arr,sum-arr[n-1],n-1) || helper(arr,sum,n-1);
        }
        else{
            dp[n][sum] = helper(arr,sum,n-1);
        }

        return dp[n][sum];
    }
}
