package dsa.stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> elToAnsMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length-1;i>=0;i--){
            if(stack.isEmpty()){
                elToAnsMap.put(nums2[i],-1);
                stack.add(nums2[i]);
            }else{
                while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                    stack.pop();
                }
                elToAnsMap.put(nums2[i],stack.isEmpty()? -1 : stack.peek());
                stack.add(nums2[i]);
            }
        }
        int []ans = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            ans[i] = elToAnsMap.get(nums1[i]);
        }
        return ans;
    }
    public  static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int []nums2 = new int[nums.length*2];
        int []ans = new int[nums2.length*2];
        for(int i = 0;i<nums.length;i++){
            nums2[i] = nums[i];
            nums2[i+nums.length] = nums[i];
        }
        for(int i = nums2.length-1;i>=0;i--){
            if(stack.isEmpty()){
                ans[i] = -1;
                stack.add(nums2[i]);
            }else{
                while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                    stack.pop();
                }
                 ans[i]= (stack.isEmpty()? -1 : stack.peek());
                 stack.add(nums2[i]);
            }
        }
        int[] ans2 = new int[nums.length];
        System.arraycopy(ans, 0, ans2, 0, nums.length);
        return ans2;
    }
}
