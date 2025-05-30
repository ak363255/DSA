package dsa.binary_search;

public class TotalNoOfOccurence {
    public static int count(int a[], int n, int x) {
        //Your code goes here
        int lowerBound = lowerBound(a,x,0,n-1);
        int upperBound = upperBound(a,x,0,n-1);
        return lowerBound >=0 && lowerBound < n && a[lowerBound]==x ? upperBound - lowerBound +1: 0;

    }
    public static int lowerBound(int []a,int fl,int s,int e){
        if(s>e)return s;
        int mid = (e-s)/2 +s;
        if(a[mid] >= fl)return lowerBound(a,fl,s,mid-1);
        else return lowerBound(a,fl,mid+1,e);
    }
    public static int upperBound(int []a,int fl,int s,int e){
        if(s>e)return e;
        int mid = (e-s)/2 +s;
        if(a[mid] <= fl)return upperBound(a,fl,mid+1,e);
        else return upperBound(a,fl,s,mid-1);
    }
}
