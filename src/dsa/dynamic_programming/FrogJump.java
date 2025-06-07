package dsa.dynamic_programming;

public class FrogJump {
    public static int minCost(int[] height) {
        // code here
        int []dp = new int[height.length];
        for(int i = 1;i<height.length;i++){
            int ans = Integer.MAX_VALUE;
            if(i-2>=0){
                ans = Math.min(ans,dp[i-2] + Math.abs(height[i] - height[i-2]));
            }
            ans = Math.min(ans,dp[i-1] + Math.abs(height[i] - height[i-1]));
            dp[i] = ans;
        }
        return dp[height.length-1];
    }

    public static int findMinCost(int i,int []height){
        if(i==0)return 0;
        int ans = Integer.MAX_VALUE;
        if(i-2>=0){
            ans = Math.min(ans,findMinCost(i-2,height) + Math.abs(height[i] - height[i-2]));
        }
        ans = Math.min(ans,findMinCost(i-1,height) + Math.abs(height[i] - height[i-1]));
        return ans;
    }
}
