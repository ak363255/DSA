package dsa.dynamic_programming;

public class HouseRobber {

    public static int rob(int[] nums) {
        int []dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            int ans = Integer.MIN_VALUE;
            ans = Math.max(ans,(i-2>=0?dp[i-2]:0)+nums[i]);
            ans = Math.max(ans,dp[i-1]);
            dp[i] = ans;
        }
     return dp[nums.length-1];
    }

    public static int findMaxRob(int i,int []nums){
        if(i==0)return nums[i];
        if(i<0)return 0;
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans,findMaxRob(i-2,nums)+nums[i]);
        ans = Math.max(ans,findMaxRob(i-1,nums));
        return ans;
    }
}
