package dsa.string;

public class MaximumNesting {
    public int maxDepth(String s) {
       int open = 0,ans = 0;
       for(char ch:s.toCharArray()){
           if(ch == '('){
               open++;
           }else if(ch == ')'){
               ans = Math.max(ans,open);
               open--;
           }
       }
       return ans;
    }
}
