package dsa.dp;

import java.util.Arrays;

public class FrogJump {

    static int dp[];
    public static int minCostJump(int []height){
        int n = height.length;
        dp = new  int[n];
        Arrays.fill(dp,-1);
        return solve(0,n,height);
    }
    public static int solve(int currentIndex,int n,int []height){
        //base
        if(currentIndex == n-1)return  0;
        if(dp[currentIndex] != -1)return dp[currentIndex];
        int ans1 = solve(currentIndex+1,n,height)+Math.abs(height[currentIndex]-height[currentIndex+1]);
        int ans2 = Integer.MAX_VALUE;
        if(currentIndex+2<n){
            ans2 = solve(currentIndex+2,n,height)+Math.abs(height[currentIndex]-height[currentIndex+2]);
        }
        dp[currentIndex] = Math.min(ans1,ans2);
        return dp[currentIndex];
    }
}
