package dsa.binary_search;

public class ShipPackages {

    public static int leastWeightCapacity(int[] weights, int d) {
        // Write your code here.
        int s = 1,e = 0,mid,ans = -1;
        boolean possible = false;
        for(int i: weights){
            e += i;
        }
        while(s<=e){
            mid = (e-s)/2+s;
            possible = shipped(weights,mid,d);
           // System.out.println("s "+s+" e "+e+" mid "+mid+" possible "+possible);
            if(possible){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return  ans;
    }

    private static boolean shipped(int[] weights, int mid, int d) {
        int wsum = 0,ans = 0;
        for(int i: weights){
           if(i>mid)return false;
           if(wsum + i > mid){
               ans++;
               wsum = i;
           }else{
               wsum += i;
           }
        }
        if(wsum > 0)ans++;
        return  ans <=d ;
    }
}
