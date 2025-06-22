package dsa.slidingwindow;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        /*
         ---------------------
         */
        int i = 0,j = 0,ans = 0;
        while(i<nums.length){
            if(nums[i]==0)k--;
            while(k<0){
                if(nums[j]==0)k++;
                j++;
            }
            ans = Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }
}
