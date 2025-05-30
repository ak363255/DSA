package dsa.binary_search;

public class RoseGarden {

    public static int roseGarden(int[] a, int k, int m) {
        // Write your code here.
        int s = 1,e = Integer.MIN_VALUE,mid,ans = -1 ;
        for(int i:a){
            e = Math.max(e,i);
        }
        while(s<=e){
            mid = (e-s)/2+s;
            boolean possible = bouquets(a,mid,k,m);
            System.out.println("s "+s+" e "+e+" mid "+ mid+" possible "+possible);
            if(possible){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }

    private static boolean bouquets(int[] a, int mid, int adj, int bouquets) {
        int count = 0,b = 0;
        for(int i: a){
            if(i <= mid){
                count++;
            }else{
                b += count/adj;
                System.out.println("count "+count+" b "+b);
                count = 0;
            }
        }
        b+= count/adj;
        return b >= bouquets;
    }
}
