package dsa.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       int limit = 1<<(nums.length);
       /*
          123
          2^3 = 8
          0-7 -> 3 bit
        */
        for(int i = 0;i<limit;i++){
            int no = i;
            List<Integer> temp = new ArrayList<>();
            int index = 0;
            while(no>0){
                if((no&1)==1){
                    temp.add(nums[index]);
                }
                index++;
                no = no>>1;
            }
            ans.add(temp);
        }
        return ans;
    }
}
