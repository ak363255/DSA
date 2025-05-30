package dsa.binary_search;

import java.util.ArrayList;

public class SearchInRotatedArray {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int []a = new int[arr.size()];
        int j  =0;
        for(int i:arr){
            a[j++] = i;
        }
        int pIndex = a[0]<= a[n-1] ?0:pivotIndex(a,0,n-1);
        System.out.println("Pivot = "+pIndex);
        int found = -1;
        if(pIndex - 1> 0){
            found = searchSortedArray(a,k,0,pIndex-1);
        }
        if(found != -1)return found;
        found = searchSortedArray(a,k,pIndex,n-1);
        return found;

    }

    private static int searchSortedArray(int[] a,int k, int s, int e) {
        if(s>e)return -1;
        int mid = (e-s)/2 +s;
        if(a[mid]== k)return mid;
        if(a[mid] > k)return searchSortedArray(a,k,s,mid-1);
        else return searchSortedArray(a,k,mid+1,e);
    }

    public static int pivotIndex(int []a,int s,int e){
        System.out.println("s "+s+" e "+e);
        if(s>=e)return s;
        int mid = (e-s)/2 + s;
        //check left part
        if(a[mid] >= a[0])return pivotIndex(a,mid+1,e);
        return pivotIndex(a,s,mid);
    }

    public static boolean searchInRotatedArrayUsingIterativeMethod(int []a,int x){
        int s = 0,e = a.length-1,mid;
        boolean found = false;
        /*
        3 4 5 0 0 1 2
         */
        while(s <= e){
            mid = (e-s)/2+s;
            System.out.println("s "+s+" e "+e+" mid "+mid);
            if(a[mid] == x || a[s]==x || a[e]==x){
                found = true;
                break;
            }else if(a[mid] > a[s]){
                //check left part is sorted ?
               if(x >= a[s] && x<=a[mid]){
                   e = mid-1;
               }else{
                   s = mid+1;
               }
            }else if(a[e] > a[mid]){
                //check right part is sorted ?
                if(x >= a[mid] && x <= a[e]){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            }else if(a[mid] == a[s] && a[s]==a[e]){
                s++;
                e--;
            }else{
                e = mid-1;
            }


        }
        return found;
    }
}
