package dsa.dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChangeProblem {

    public static int count(int coins[], int sum) {
        // code here.
        int n = coins.length;
        int dp[][] = new int[n][sum+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return findNoOfWays(n-1,sum,coins,dp);

    }

    public static int findNoOfWays(int i,int csum,int []coins,int [][]dp){
        if(i==0){
            if(csum%coins[i]==0)return 1;
            return 0;
        }
        if(dp[i][csum] != -1)return dp[i][csum];
        int notTake = findNoOfWays(i-1,csum,coins,dp);
        int take = 0;
        if(coins[i] <= csum){
            take = findNoOfWays(i,csum-coins[i],coins,dp);
        }
        return dp[i][csum] = take + notTake;
    }

    public static int findNoOfWaysBottomUp(int csum,int []coins){
        int dp[][] = new int[coins.length][csum];
        for(int i = 0;i<=csum;i++){
            if(i%coins[i]==0)dp[0][i] = 1;
            else dp[0][i] = 0;
        }
        for(int i = 1;i<coins.length;i++){
            for(int j = 0;j<=csum;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(coins[i] <= j){
                    take = dp[i][j-coins[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[coins.length-1][csum];
    }
}
