package dsa.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortCharFreq {
    public static String frequencySort(String s) {
        HashMap<Character,CharFreq> mapping = new HashMap<>();
        for(char ch:s.toCharArray()){
            if(mapping.containsKey(ch)){
                mapping.get(ch).count++;
            }else{
                mapping.put(ch,new CharFreq(ch,1));
            }
        }
        CharFreq []a = new CharFreq[mapping.size()];
        int  i = 0;
        for(Map.Entry<Character,CharFreq> e: mapping.entrySet()){
            a[i++] = e.getValue();
        }
        Arrays.sort(a, new Comparator<CharFreq>() {
            @Override
            public int compare(CharFreq o1, CharFreq o2) {
                return o2.count - o1.count;
            }
        });
        StringBuilder ans = new StringBuilder();
        for(CharFreq charFreq:a){
            ans.append(charFreq.ch);
        }
        return ans.toString();
    }
    public static class CharFreq{
        char ch;
        int count;
        CharFreq(char ch,int count){
            this.ch = ch;
            this.count  = count;
        }
    }

}
