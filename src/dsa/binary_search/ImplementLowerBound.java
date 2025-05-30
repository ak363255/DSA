package dsa.binary_search;

public class ImplementLowerBound {

    public static int lowerBound(int []a, int n, int x) {
        // Write your code here
        return lowerBoundUsingIterativeMethod(a,x);
    }

    public static int go(int a[],int lb,int s,int e){
        if(s > e)return s;
        int mid = (e-s)/2 +s;
        if(a[mid] >= lb)return go(a,lb,s,mid-1);
        else return go(a,lb,mid+1,e);
    }

    public static int lowerBoundUsingIterativeMethod(int []a,int x){
        int s = 0,e = a.length-1,ans = a.length,mid;
        while(s <= e){
            mid = (e-s)/2 + s;
            System.out.println("s "+s+" e "+e+" mid "+mid);
            if(a[mid] >= x){
                ans = mid;
                e = mid-1;
            }else{
                s++;
            }
        }
        return ans;
    }
}
