package dsa.sorting;

public class SelectionSort {
    public  static int[] selectionSort(int a[]){
        int n = a.length,temp,minIndex;
        for(int i =0;i<n-1;i++){
            minIndex = i;
            for(int j = i+1;j<n;j++){
                if(a[minIndex]>a[j]){
                    minIndex = j;
                }
            }
            temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return a;
    }
}
