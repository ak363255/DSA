package dsa.stack_queue;

import java.util.Stack;

public class AsteriodCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for(int i = 0;i<n;i++){
            if(!stack.isEmpty() && asteroids[i] < 0 && stack.peek()>0){
                boolean isVanished = false;
                while(!stack.isEmpty() && asteroids[i] < 0 && stack.peek()>0){
                    if(-1*asteroids[i] > stack.peek()){
                        stack.pop();
                    }else if(-1*asteroids[i] == stack.peek()){
                        stack.pop();
                        isVanished = true;
                        break;
                    }else{
                        isVanished = true;
                        break;
                    }
                }
                if(!isVanished){
                    stack.add(asteroids[i]);
                }
            }else{
                stack.add(asteroids[i]);
            }
        }
        int []ans = new int[stack.size()];
        int i = 0;
        for(int el:stack){
            ans[i++] = el;
        }
        return ans;
    }
}
