package dsa.binary_search;

public class FloorAndCeiling {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        // Wriute your code here.
        int lowerBound = lowerBound(a,x,0,a.length-1);
        if(lowerBound>=0&&lowerBound<a.length){
            if(a[lowerBound]==x)return new int[]{x,x};
            if(lowerBound -1 >=0)return new int[]{a[lowerBound-1],a[lowerBound]};
            else return new int[]{-1,a[lowerBound]};
        }else{
            return new int[]{a[lowerBound-1],-1};
        }
    }

    public static int lowerBound(int []a,int fl,int s,int e){
        if(s>e)return s;
        int mid = (e-s)/2 +s;
        if(a[mid] >= fl)return lowerBound(a,fl,s,mid-1);
        else return lowerBound(a,fl,mid+1,e);
    }
}
