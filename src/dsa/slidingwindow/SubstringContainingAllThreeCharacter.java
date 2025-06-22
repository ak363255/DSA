package dsa.slidingwindow;

import java.util.HashMap;

public class SubstringContainingAllThreeCharacter {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> charMap = new HashMap<>();
        s = s.toLowerCase();
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            charMap.put(s.charAt(i),i);
            if(charMap.size()==3){
                ans += (Math.min(Math.min(charMap.get('a'),charMap.get('b')),charMap.get('c'))+1);
            }
        }
        return ans;
    }
}
