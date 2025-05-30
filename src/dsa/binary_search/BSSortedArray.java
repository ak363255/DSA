package dsa.binary_search;

public class BSSortedArray {

    public static int search(int []a, int target) {
        // Write your code here.
        return searchInSortedArrayUsingIterativeMethod(a,target);
    }

    public static int go(int []a, int target ,int s,int e){
        if(s>e)return -1;
        int mid = (e-s)/2 + s;
        if(a[mid]==target)return mid;
        else if(a[mid]>target)return go(a,target,s,mid-1);
        else return go(a,target,mid+1,e);
    }
    public static int searchInSortedArrayUsingIterativeMethod(int []a,int target){
        int ans = -1,s = 0,e = a.length-1,mid;
        while(s<e){
            mid = (e-s)/2+s;
            if(a[mid] == target){
                ans = mid;
                break;
            }else if(a[mid] > target){
                e--;
            }else{
                s++;
            }
        }
        return ans;
    }
}
