package dsa.binary_search;

public class LargestSubarraySum {

    public static int largestSubarraySumMinimized(int []a, int k) {
        // Write Your Code Here
        long s = 0,e=0,mid;
        boolean possible = false;
        int ans = k> a.length ? -1: 0;
        for(int i:a){
            s = Math.max(i,s);
            e += i;
        }
        while( s<= e){
            mid = (e-s)/2+s;
            possible = splitArray(a,mid,k);
            if(possible){
                ans = (int)mid;
                e = mid-1;
            }else{
               s = mid+1;
            }
        }
        return ans;
    }

    private static boolean splitArray(int[] a, long maxSum, int no) {
        int count = 1;
        long sum = 0;
        for(int i:a){
            if(sum + i > maxSum){
                count++;
                sum = i;
            }else{
                sum += i;
            }
        }
        return count <= no;
    }
}
