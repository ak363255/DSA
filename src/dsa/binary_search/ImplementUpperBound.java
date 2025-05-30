package dsa.binary_search;

public class ImplementUpperBound {

    public static int upperBound(int []a, int x, int n){
        // Write your code here.
        return go(a,x,0,a.length-1);
    }

    public static int go(int []a,int up,int s,int e){
        if(s > e)return  s;
        int mid = (e-s)/2 + s;
        if(a[mid] > up)return go(a,up,s,mid-1);
        else return go(a,up,mid+1,e);
    }

    public static int upperBoundUsingIterativeMethod(int []a,int x){
        int s = 0,e = a.length-1,mid,ans = a.length;
        while(s <=e){
            mid = (e-s)/2 +s;
            if(a[mid] > x){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }
}
