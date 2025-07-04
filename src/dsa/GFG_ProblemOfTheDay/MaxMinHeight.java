package dsa.GFG_ProblemOfTheDay;

public class MaxMinHeight {
    public static int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = Math.min(min, i);
        }
        int max = min + k;
        int ans = 0, l = min, r = max, mid;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (maxHeightPossible(arr, k, w, mid)) {
                l = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    public static boolean maxHeightPossible(int []c,int k,int w,int targetHeight){
        int[] a = new int[c.length];
        for(int i=0;i<c.length;i++)a[i]=c[i];
        int currentHeight;
        int []b = new int[a.length+1];
        for(int i = 0;i<a.length;i++){
            b[i] = b[i] + (i-1>=0?b[i-1]:0);
            currentHeight = a[i] + b[i];
            if(currentHeight + k < targetHeight)return false;
            if(currentHeight < targetHeight){
                int need = targetHeight - currentHeight;
                b[i] += need;
                if(i+w<b.length)b[i+w] -= need;
                k -= need;
            }
        }
        return true;
    }
}
