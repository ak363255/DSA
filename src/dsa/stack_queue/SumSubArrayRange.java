package dsa.stack_queue;

import javax.swing.plaf.IconUIResource;
import java.util.Stack;

public class SumSubArrayRange {

    public static long subArrayRanges(int[] nums) {
          return  maxSumSubArray(nums) - minSumSubArray(nums);
    }

    public static long minSumSubArray(int []nums){
        int n = nums.length;
        ElementWithIndex []elementWithIndices = new ElementWithIndex[n];
        for(int i = 0;i<n;i++){
            elementWithIndices[i] = new ElementWithIndex(nums[i],0,0,i);
        }
        Stack<ElementWithIndex> lStack = new Stack<>();
        Stack<ElementWithIndex> rStack = new Stack<>();
        long ans = 0;
        for(int i = 0;i<n;i++){
            ElementWithIndex elementWithIndex = elementWithIndices[i];
            while (!lStack.isEmpty() && lStack.peek().data > elementWithIndex.data){
                lStack.pop();
            }
            elementWithIndex.lCount = lStack.isEmpty() ? i+1: i - lStack.peek().cIndex;
            lStack.add(elementWithIndex);
        }
        for(int i = n-1;i>=0;i--){
            ElementWithIndex elementWithIndex = elementWithIndices[i];
            while(!rStack.isEmpty()  && rStack.peek().data >= elementWithIndex.data){
                rStack.pop();
            }
            elementWithIndex.rCount = rStack.isEmpty() ? n - i: rStack.peek().cIndex - i;
            rStack.add(elementWithIndex);
        }

        for(int i = 0;i<n;i++){
            ElementWithIndex elementWithIndex = elementWithIndices[i];
            ans += (((long) elementWithIndex.data )*elementWithIndex.lCount*elementWithIndex.rCount);
        }
        return ans;
    }
    public static long maxSumSubArray(int []nums){
        int n = nums.length;
        ElementWithIndex []elementWithIndices = new ElementWithIndex[n];
        for(int i = 0;i<n;i++){
            elementWithIndices[i] = new ElementWithIndex(nums[i],0,0,i);
        }
        Stack<ElementWithIndex> lStack = new Stack<>();
        Stack<ElementWithIndex> rStack = new Stack<>();
        long ans = 0;
        for(int i = 0;i<n;i++){
            ElementWithIndex elementWithIndex = elementWithIndices[i];
            while (!lStack.isEmpty() && lStack.peek().data < elementWithIndex.data){
                lStack.pop();
            }
            elementWithIndex.lCount = lStack.isEmpty() ? i+1: i - lStack.peek().cIndex;
            lStack.add(elementWithIndex);
        }
        for(int i = n-1;i>=0;i--){
            ElementWithIndex elementWithIndex = elementWithIndices[i];
            while(!rStack.isEmpty()  && rStack.peek().data <= elementWithIndex.data){
                rStack.pop();
            }
            elementWithIndex.rCount = rStack.isEmpty() ? n - i: rStack.peek().cIndex - i;
            rStack.add(elementWithIndex);
        }

        for(int i = 0;i<n;i++){
            ElementWithIndex elementWithIndex = elementWithIndices[i];
            ans += (((long) elementWithIndex.data )*elementWithIndex.lCount*elementWithIndex.rCount);
        }
        return ans;
    }
    static class ElementWithIndex{
        int data,lCount,rCount,cIndex;
        ElementWithIndex(int data,int lCount,int rCount,int cIndex){
            this.data = data;
            this.lCount = lCount;
            this.rCount = rCount;
            this.cIndex = cIndex;
        }
    }
}
