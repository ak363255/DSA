package dsa.string;

import java.util.HashMap;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mapping = new HashMap<>();
        HashMap<Character,Character> rmapping = new HashMap<>();
        if(s.length() != t.length())return false;
        int l = s.length();
        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();
        for(int i = 0;i<l;i++){
            if(mapping.containsKey(sArray[i]) && mapping.get(sArray[i]) != tArray[i]){
                return false;
            }
            if(rmapping.containsKey(tArray[i]) && rmapping.get(tArray[i]) != sArray[i]){
                return false;
            }

            mapping.put(sArray[i],tArray[i]);
            rmapping.put(tArray[i],sArray[i]);
        }
        return true;
    }
}
