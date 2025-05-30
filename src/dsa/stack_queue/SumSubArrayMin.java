package dsa.stack_queue;

import java.util.Stack;

public class SumSubArrayMin {


    public static int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int []leftCount = new int[n];
        int []rightCount = new int[n];
        Stack<Integer> stack = new Stack<>();
        int ans = 0,mod = 1000000000+7;
        //compute right count
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            rightCount[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.add(i);
        }
        //compute left count
        stack = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            leftCount[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.add(i);
        }
        for(int i = 0;i<n;i++){
            System.out.println("left "+leftCount[i]+" right "+rightCount[i]);
        }
        for(int i = 0;i<n;i++){
            ans =(ans%mod + arr[i]%mod*((leftCount[i]%mod*rightCount[i]%mod)%mod)%mod)%mod;
        }
        return ans;
    }
}
