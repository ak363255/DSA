package dsa.string;

public class Anagram {
    public boolean isAnagram(String s, String t) {
          int sCount[] = new int[26];
          int tCount[] = new int[26];
          for(char ch:s.toCharArray()){
              sCount[ch-'a']++;
          }
        for(char ch:t.toCharArray()){
            tCount[ch-'a']++;
        }
        for(int i = 0;i<26;i++){
            if(sCount[i] != tCount[i])return false;
        }
        return true;
    }
}
