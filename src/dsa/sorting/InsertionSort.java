package dsa.sorting;

public class InsertionSort {

    public static int[] insertionSort(int a[]){
        int n = a.length,temp,j;
        for(int i = 0;i<n;i++){
            j = i;
            while(j>0 && a[j-1] > a[j]){
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                j--;
            }
        }
        return a;
    }
}
