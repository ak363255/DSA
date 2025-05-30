package dsa.string;

import java.util.HashMap;

public class RomanToInt {
    public static int romanToInt(String s) {
        HashMap<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        int ans = 0;
        int i = 0;
        while (i<s.length()){
            if(i+1 <s.length() && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1))){
                ans += (romanMap.get(s.charAt(i+1)) - romanMap.get(s.charAt(i)));
                i+=2;
            }else{
                ans += romanMap.get(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
