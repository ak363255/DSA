package dsa.sorting;

import java.util.ArrayList;

public class MergeSort {
    public static int[] mergeSort(int a[]){
        merge(a,0,a.length-1);
        return a;
    }

    public static void merge(int a[],int s,int e){
        if(s==e)return;
        int mid = (e-s)/2 + s;
        merge(a,s,mid);
        merge(a,mid+1,e);
        mergeSortedArray(a,s,mid,mid+1,e);
    }

    private static void mergeSortedArray(int[] a, int i, int j, int k , int l) {
        int start = i,end = l;
        ArrayList<Integer> temp = new ArrayList<>();
        while(i<=j && k<=l){
            if(a[i]<=a[k]){
                temp.add(a[i]);
                i++;
            }else{
                temp.add(a[k]);
                k++;
            }
        }
        while(i<=j){
            temp.add(a[i]);
            i++;
        }
        while(k<=l){
            temp.add(a[k]);
            k++;
        }
        int index = 0;
        while(start<=end){
            a[start] = temp.get(index++);
            start++;
        }
    }
}
