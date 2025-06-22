package dsa.slidingwindow;

import java.util.HashMap;

public class SubArrayWithKDiffInteger {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithLessThanEqualToKDistinct(nums,k) - (k>1?subarraysWithLessThanEqualToKDistinct(nums,k-1):0);
    }
    public static int subarraysWithLessThanEqualToKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> charCount = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while (i < nums.length) {
            charCount.put(nums[i], charCount.getOrDefault(nums[i], 0) + 1);
            while (j < i && charCount.size() > k) {
                int count = charCount.get(nums[j]) - 1;
                if (count == 0) {
                    charCount.remove(nums[j]);
                } else {
                    charCount.put(nums[j], count);
                }
                j++;
            }
            ans += i - j + 1;
            i++;
        }
        return ans;
    }
}
