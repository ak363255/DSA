package dsa.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class RemoveKDigit {

    public static String removeKdigits(String num, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        char []cArray = num.toCharArray();
        for(int i = 0;i<num.length();i++){
            while(k > 0 && !queue.isEmpty() && queue.getLast() >= (cArray[i]-'0')){
                queue.removeLast();
                k--;
            }
            queue.add(cArray[i]-'0');
        }
        while(!queue.isEmpty() && queue.getFirst() == 0){
            queue.removeFirst();
        }
        StringBuilder ans = new StringBuilder();
        int size = queue.size();
        for(int i = 0;i<size-k;i++){
            ans.append(queue.removeFirst());
        }
        if(ans.isEmpty())return "0";
        return ans.toString();
    }
}
