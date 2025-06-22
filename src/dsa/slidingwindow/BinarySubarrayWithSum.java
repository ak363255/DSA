package dsa.slidingwindow;

import java.util.HashMap;

public class BinarySubarrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> sumFre = new HashMap<>();
        sumFre.put(0,1);
        int sum = 0,subArray = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(sumFre.containsKey(sum - goal)){
                subArray += sumFre.get(sum - goal);
            }
            sumFre.put(sum,sumFre.getOrDefault(sum,0)+1);
        }
        return subArray;
    }
}
