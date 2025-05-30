package dsa.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        int no = 2<<nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<no;i++){
            int index = 0,temp = i;
            List<Integer> subset = new ArrayList<>();
            while(temp > 0){
                if((temp&1)==1){
                    subset.add(nums[index]);
                }
                temp >>= 1;
                index++;
            }
            ans.add(subset);
        }
        return ans;
    }
}
