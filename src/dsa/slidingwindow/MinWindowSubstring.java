package dsa.slidingwindow;

import java.util.HashMap;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        char []a = s.toCharArray();
        char []b = t.toCharArray();
        for(char ch: b){
            charCount.put(ch,charCount.getOrDefault(ch,0)+1);
        }
        int i = 0,j = 0,ans = Integer.MAX_VALUE,count = 0,l = -1,r = -1;
        String ansString = "";
        while(i < a.length){
            if(charCount.containsKey(a[i]) && charCount.get(a[i]) > 0)count++;
            charCount.put(a[i],charCount.getOrDefault(a[i],0)-1);
            while(count == b.length){
                if((i-j+1) < ans){
                    ans = (i-j+1);
                    l = j;
                    r = i;
                }
                int c = charCount.get(a[j]) +1;
                if(c > 0)count--;
                charCount.put(a[j],c);
                j++;
            }
            i++;
        }
        return l !=-1 && r !=-1 ? s.substring(l,r+1):"";
    }
}
