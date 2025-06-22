package dsa.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithUniques {

    public static int longestkSubstr(String s, int k) {
        // code here
        s = s.toLowerCase();
        HashMap<Character,Integer> charCount = new HashMap<>();
        int i = 0,j = 0,ans = 0;
        while(i < s.length()){
            charCount.put(s.charAt(i),charCount.getOrDefault(s.charAt(i),0)+1);
            while(j<i && charCount.size() > k){
                int count = charCount.get(s.charAt(j)) -1;
                if(count==0){
                    charCount.remove(s.charAt(j));
                }else{
                    charCount.put(s.charAt(j),count);
                }
                j++;
            }
            if(charCount.size() == k){
                ans = Math.max(ans,i-j+1);
            }
            i++;
        }
        return ans;
    }
}
