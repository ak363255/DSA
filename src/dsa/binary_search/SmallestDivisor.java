package dsa.binary_search;

public class SmallestDivisor {
    public static int smallestDivisor(int a[], int limit) {
        // Write your coder here
        int s = 1,e = Integer.MIN_VALUE,ans = -1,mid;
        boolean possible = false;
        for(int i: a){
            e = Math.max(i,e);
        }
        while(s<=e){
            mid = (e-s)/2+s;
            possible = divisorSum(a,mid,limit);
            if(possible){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }

    private static boolean divisorSum(int[] a, int mid, int limit) {
        boolean possible = false;
        int sum = 0;
        for(int i: a){
            sum += (i+mid-1)/mid;
        }
        return sum <= limit;
    }
}
