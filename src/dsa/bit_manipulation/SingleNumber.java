package dsa.bit_manipulation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SingleNumber {

    public static  int[] singleNumber(int[] nums) {
        //your code goes here
        /*
            ans= 3^5 = 6
            011
            101
         */
        int combined = 0;
        for(int i:nums){
            combined = combined^i;
        }
        int left = 0;
        while(combined > 0){
            if((combined&1)==1){
                break;
            }
            left++;
            combined = combined>>1;
        }
        // Get the lowest set bit (works correctly even if combined is negative)
        long mask = (long)combined & -(long)combined;

        int set1 = 0, set2 = 0;
        for (int i : nums) {
            if (((long)i & mask) != 0) {
                set1 ^= i;
            } else {
                set2 ^= i;
            }
        }
        int ans[] = new int[]{set1,set2};
        Arrays.sort(ans);
        return ans;
    }
}
