package dsa.string;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        boolean match = false;
        char start;
        int min = Integer.MAX_VALUE;
        for(String s:strs){
            min = Math.min(min,s.length());
        }
        for(int i = 0;i<min;i++){
            match = true;
            start = strs[0].charAt(i);
            for(int j = 1;j<strs.length;j++){
                if(strs[j].charAt(i) != start){
                    match = false;
                    break;
                }
            }
            if(match){
                ans.append(start);
            }else{
                break;
            }
        }
        return ans.toString();
    }
}
