package dsa.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
          /*
               -------------------
           */
        HashMap<Character,Integer> charIndex = new HashMap<>();
        int i=0,j = 0,ans = 0;
        char []cArray = s.toCharArray();
        while(i<cArray.length){
            if(charIndex.containsKey(cArray[i])){
                j = Math.max(j,charIndex.get(cArray[cArray[i]])+1) ;
            }
            ans = Math.max(ans,i-j+1);
            charIndex.put(cArray[i],i);
            i++;
        }
        return ans;
    }
}
