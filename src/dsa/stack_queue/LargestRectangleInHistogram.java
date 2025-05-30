package dsa.stack_queue;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static  int largestRectangleArea(int[] heights) {
            return largestHistogram(heights);
    }

    public static int largestHistogram(int []nums){
        int n = nums.length;
        SumSubArrayRange.ElementWithIndex[]elementWithIndices = new SumSubArrayRange.ElementWithIndex[n];
        for(int i = 0;i<n;i++){
            elementWithIndices[i] = new SumSubArrayRange.ElementWithIndex(nums[i],0,0,i);
        }
        Stack<SumSubArrayRange.ElementWithIndex> lStack = new Stack<>();
        Stack<SumSubArrayRange.ElementWithIndex> rStack = new Stack<>();
        int ans = 0;
        for(int i = 0;i<n;i++){
            SumSubArrayRange.ElementWithIndex elementWithIndex = elementWithIndices[i];
            while (!lStack.isEmpty() && lStack.peek().data >= elementWithIndex.data){
                lStack.pop();
            }
            elementWithIndex.lCount = lStack.isEmpty() ? i+1: i - lStack.peek().cIndex;
            lStack.add(elementWithIndex);
        }
        for(int i = n-1;i>=0;i--){
            SumSubArrayRange.ElementWithIndex elementWithIndex = elementWithIndices[i];
            while(!rStack.isEmpty()  && rStack.peek().data >= elementWithIndex.data){
                rStack.pop();
            }
            elementWithIndex.rCount = rStack.isEmpty() ? n - i: rStack.peek().cIndex - i;
            rStack.add(elementWithIndex);
        }

        for(int i = 0;i<n;i++){
            SumSubArrayRange.ElementWithIndex elementWithIndex = elementWithIndices[i];
            ans = Math.max(ans,((elementWithIndex.data)*(elementWithIndex.lCount+elementWithIndex.rCount-1)));
        }
        return ans;
    }
}
