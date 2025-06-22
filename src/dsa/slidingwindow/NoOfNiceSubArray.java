package dsa.slidingwindow;

public class NoOfNiceSubArray {
    public static int numberOfSubarrays(int[] nums, int k) {
       int i = 0, j = 0,left,right = 0,ans = 0;
       while(i<nums.length){
           if(nums[i]%2==1)k--;
           if(k==0){
               left = 0;
               right = 1;
               while (i+1 < nums.length && nums[i+1]%2==0){
                   i++;
                   right++;
               }
               while(k==0){
                   left++;
                   if(nums[j]%2==1)k++;
                   j++;
               }
               ans += (left*right);
           }

               i++;

       }
       return ans;
    }
}
