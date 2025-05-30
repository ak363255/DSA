package dsa.string;

import java.util.HashMap;

public class SubStringWithAtMostKDistinctChar {
     public static int countSubstr(String s, int k) {
         char []a = s.toCharArray();
         return countSubStrLessThankK(a,k) - countSubStrLessThankK(a,k-1);
    }

    public static int countSubStrLessThankK(char cArray[],int k){
         int current=0,prev = 0,ans = 0,charCount;
        HashMap<Character,Integer> charMap = new HashMap<>();
        while(current < cArray.length){
            charMap.put(cArray[current],charMap.getOrDefault(cArray[current],0)+1);
            while(charMap.size()>k){
                charCount = charMap.get(cArray[prev]);
                if(charCount-1<=0){
                    charMap.remove(cArray[prev]);
                }else{
                    charMap.put(cArray[prev],charCount-1);
                }
                prev++;
            }
            ans += (current - prev + 1);
            current++;
        }

        return ans;
    }

    /*
       1  2  2  1
       
       1 2 3 4 5


     */
}

