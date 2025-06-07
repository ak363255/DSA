package dsa.dynamic_programming;

public class ClimbStairs {
    public static  int climbStairs(int n) {
         int []dp = new int[n+1];
         dp[0] = 1;
         for(int i = 1;i<=n;i++){
             dp[i] = dp[i-1] + (i-2>=0?dp[i-2]:0);
         }
         return dp[n];


         // return findClimbStairs(n);
    }
    public static int findClimbStairs(int i){
        if(i==0)return 1;
        if(i<0)return 0;
        return findClimbStairs(i-1) + findClimbStairs(i-2);
    }
}
