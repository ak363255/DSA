package dsa.array;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {


    public static int getLongestZeroSumSubarrayLength(int []a){
             /*
               1, -1, 0, 0, 1
        psum   1   0  0  0  1
              */

        HashMap<Long,Integer> pMap = new HashMap<>();
        int n = a.length,ans = 0,prevIndex;
        long sum = 0;
        for(int i = 0;i<n;i++){
            sum += a[i];
            if(sum ==0){
                ans = Math.max(ans,i+1);
            }else{
                if(pMap.containsKey(sum)){
                    prevIndex = pMap.get(sum)+1;
                    ans = Math.max(ans,((i+1)-prevIndex));
                }
            }
            if(!pMap.containsKey(sum)){
                pMap.put(sum,i);
            }
        }
        return ans;
    }
}
