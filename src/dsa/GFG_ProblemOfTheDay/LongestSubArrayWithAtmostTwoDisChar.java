package dsa.GFG_ProblemOfTheDay;

import java.util.HashMap;

public class LongestSubArrayWithAtmostTwoDisChar {
    public int totalElements(int[] arr) {
        // code here
        int ans = 0,l = 0,r = 0;
        HashMap<Integer,Integer> charMap = new HashMap<>();
        while(r < arr.length){
            charMap.put(arr[r],charMap.getOrDefault(arr[r],0)+1);
            while(charMap.size() > 2){
                int count = charMap.get(arr[l])-1;
                if(count == 0){
                    charMap.remove(arr[l]);
                }else{
                    charMap.put(arr[l],count);
                }
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}

