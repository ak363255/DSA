package dsa.sorting;

public class BubbleSort {

    public static int[] bubbleSort(int a[]){
        int n = a.length,temp;
        for(int i = n-1;i>0;i--){
            for(int j = 0;j<i;j++){
                if(a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
}
